package com.fincity.security.service;

import static com.fincity.nocode.reactor.util.FlatMapUtil.flatMapMono;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fincity.saas.common.security.util.SecurityContextUtil;
import com.fincity.saas.commons.jooq.service.AbstractJOOQUpdatableDataService;
import com.fincity.saas.commons.util.StringUtil;
import com.fincity.security.dao.ClientPasswordPolicyDAO;
import com.fincity.security.dto.ClientPasswordPolicy;
import com.fincity.security.jooq.tables.records.SecurityClientPasswordPolicyRecord;

import reactor.core.publisher.Mono;

@Service
public class ClientPasswordPolicyService extends
        AbstractJOOQUpdatableDataService<SecurityClientPasswordPolicyRecord, ULong, ClientPasswordPolicy, ClientPasswordPolicyDAO> {

	private static final String CLIENT_PASSWORD_POLICY = "client password policy";

	@Autowired
	private SecurityMessageResourceService securityMessageResourceService;

	@Autowired
	private ClientService clientService;

	private final Set<Character> specialCharacters = Set.of('~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
	        '_', '-', '+', '=', '{', '}', '[', ']', '|', '\\', '/', ':', ';', '\"', '\'', '<', '>', ',', '.', '?');

	@PreAuthorize("hasAuthority('Authorities.Client_Password_Policy_CREATE')")
	@Override
	public Mono<ClientPasswordPolicy> create(ClientPasswordPolicy entity) {

		return SecurityContextUtil.getUsersContextAuthentication()

		        .flatMap(ca ->
				{

			        ULong currentUser = ULong.valueOf(ca.getLoggedInFromClientId());

			        if (ca.isSystemClient() || currentUser.equals(entity.getClientId()))
				        return super.create(entity);

			        return this.clientService.isBeingManagedBy(currentUser, entity.getClientId())
			                .flatMap(managed -> managed.booleanValue() ? super.create(entity) : Mono.empty());
		        })
		        .switchIfEmpty(securityMessageResourceService.throwMessage(HttpStatus.FORBIDDEN,
		                SecurityMessageResourceService.FORBIDDEN_CREATE, CLIENT_PASSWORD_POLICY));
	}

	@PreAuthorize("hasAuthority('Authorities.Client_Password_Policy_READ')")
	@Override
	public Mono<ClientPasswordPolicy> read(ULong id) {

		return super.read(id);
	}

	@Override
	protected Mono<ClientPasswordPolicy> updatableEntity(ClientPasswordPolicy entity) {
		return this.read(entity.getId())
		        .map(e ->
				{
			        e.setAtleastOneDigit(entity.isAtleastOneDigit());
			        e.setAtleastoneLowercase(entity.isAtleastoneLowercase());
			        e.setAtleastOneSpecialChar(entity.isAtleastOneSpecialChar());
			        e.setAtleastOneUppercase(entity.isAtleastOneUppercase());
			        e.setNoFailedAttempts(entity.getNoFailedAttempts());
			        e.setPassExpiryInDays(entity.getPassExpiryInDays());
			        e.setPassExpiryWarnInDays(entity.getPassExpiryWarnInDays());
			        e.setPassHistoryCount(entity.getPassHistoryCount());
			        e.setPassMaxLength(entity.getPassMaxLength());
			        e.setPassMinLength(entity.getPassMinLength());
			        e.setPercentageName(entity.getPercentageName());
			        e.setRegex(entity.getRegex());
			        e.setSpacesAllowed(entity.isSpacesAllowed());
			        return e;
		        });
	}

	@Override
	protected Mono<Map<String, Object>> updatableFields(ULong key, Map<String, Object> fields) {

		if (fields == null || key == null)
			return Mono.just(new HashMap<String, Object>());

		fields.remove("clientId");
		fields.remove("updatedAt");
		fields.remove("updatedBy");
		fields.remove("createdAt");
		fields.remove("createdBy");

		return Mono.just(fields);
	}

	@PreAuthorize("hasAuthority('Authorities.Client_Password_Policy_UPDATE')")
	@Override
	public Mono<ClientPasswordPolicy> update(ULong key, Map<String, Object> fields) {
		return this.dao.canBeUpdated(key)
		        .flatMap(e -> e.booleanValue() ? super.update(key, fields) : Mono.empty())
		        .switchIfEmpty(securityMessageResourceService.throwMessage(HttpStatus.FORBIDDEN,
		                SecurityMessageResourceService.FORBIDDEN_CREATE, CLIENT_PASSWORD_POLICY));
	}

	@PreAuthorize("hasAuthority('Authorities.Client_Password_Policy_UPDATE')")
	@Override
	public Mono<ClientPasswordPolicy> update(ClientPasswordPolicy entity) {

		return this.dao.canBeUpdated(entity.getId())
		        .flatMap(e -> e.booleanValue() ? super.update(entity) : Mono.empty())
		        .switchIfEmpty(securityMessageResourceService.throwMessage(HttpStatus.FORBIDDEN,
		                SecurityMessageResourceService.FORBIDDEN_CREATE, CLIENT_PASSWORD_POLICY));
	}

	@PreAuthorize("hasAuthority('Authorities.Client_Password_Policy_DELETE')")
	@Override
	public Mono<Integer> delete(ULong id) {
		return this.dao.canBeUpdated(id)
		        .flatMap(e -> e.booleanValue() ? super.delete(id) : Mono.empty())
		        .switchIfEmpty(securityMessageResourceService.throwMessage(HttpStatus.FORBIDDEN,
		                SecurityMessageResourceService.FORBIDDEN_CREATE, CLIENT_PASSWORD_POLICY));
	}

	public Mono<Boolean> checkAllConditions(ULong clientId, String password) {

		return flatMapMono(

		        SecurityContextUtil::getUsersContextAuthentication,

		        ca -> this.dao.getByClientId(clientId, ULong.valueOf(ca.getLoggedInFromClientId())),

		        (ca, passwordPolicy) -> checkAlphanumericExists(passwordPolicy, password),

		        (ca, passwordPolicy, isAlphaNumberic) -> checkInSpecialCharacters(password),

		        (ca, passwordPolicy, isAlphaNumberic, isSpecial) ->
				{

			        if (passwordPolicy.isSpacesAllowed())
				        return Mono.just(true);

			        if (password.indexOf(' ') != -1)
				        return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
				                SecurityMessageResourceService.SPACES_MISSING);

			        return Mono.just(true);
		        },

		        (ca, passwordPolicy, isAlphaNumberic, isSpecial, isSpace) ->
				{

			        String regex = passwordPolicy.getRegex();

			        if (StringUtil.safeIsBlank(regex))
				        return Mono.just(true);

			        return checkRegexPattern(password, regex);

		        },

		        (ca, passwordPolicy, isAlphaNumberic, isSpecial, isSpace, isRegex) -> this
		                .checkStrengthOfPassword(passwordPolicy, password))
		        .defaultIfEmpty(true);
	}

	private Mono<Boolean> checkAlphanumericExists(ClientPasswordPolicy passwordPolicy, String password) {

		if (passwordPolicy.isAtleastOneUppercase() && !checkExistsInBetween(password, 'A', 'Z')) {
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.CAPTIAL_LETTERS_MISSING);
		}

		if (passwordPolicy.isAtleastOneUppercase() && !checkExistsInBetween(password, 'a', 'z')) {
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.SMALL_LETTERS_MISSING);
		}

		if (passwordPolicy.isAtleastOneDigit() && !checkExistsInBetween(password, '0', '9')) {
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.NUMBERS_MISSING);
		}

		return Mono.just(true);
	}

	private boolean checkExistsInBetween(String password, char minBoundary, char maxBoundary) {

		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (ch >= minBoundary && ch <= maxBoundary)
				return true;

		}

		return false;
	}

	private Mono<Boolean> checkStrengthOfPassword(ClientPasswordPolicy passwordPolicy, String password) {

		if (passwordPolicy.getPassMaxLength() != null && password.length() > passwordPolicy.getPassMaxLength()
		        .intValue())
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.MAX_LENGTH_ERROR, passwordPolicy.getPassMaxLength());

		if (passwordPolicy.getPassMinLength() != null && password.length() < passwordPolicy.getPassMinLength()
		        .intValue())
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.MIN_LENGTH_ERROR, passwordPolicy.getPassMinLength());

		return Mono.just(true);

	}

	private Mono<Boolean> checkInSpecialCharacters(String password) {

		for (int i = 0; i < password.length(); i++) {
			Character ch = password.charAt(i);
			if (specialCharacters.contains(ch))
				return Mono.just(true);
		}

		return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
		        SecurityMessageResourceService.SPECIAL_CHARACTERS_MISSING);
	}

	private Mono<Boolean> checkRegexPattern(String password, String regex) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matches = pattern.matcher(password);
		if (!matches.find())
			return securityMessageResourceService.throwMessage(HttpStatus.BAD_REQUEST,
			        SecurityMessageResourceService.REGEX_MISMATCH);

		return Mono.just(true);
	}

}
