package com.fincity.saas.data.service;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import com.fincity.saas.common.security.util.SecurityContextUtil;
import com.fincity.saas.commons.configuration.service.AbstractMessageService;

import reactor.core.publisher.Mono;

@Service
public class DataMessageResourceService extends AbstractMessageService {

	public static final String OBJECT_NOT_FOUND = "object_not_found";
	public static final String OBJECT_NOT_FOUND_TO_UPDATE = "object_not_found_to_update";
	public static final String FORBIDDEN_CREATE = "forbidden_create";
	public static final String FORBIDDEN_PERMISSION = "forbidden_permission";
	public static final String UNABLE_TO_DELETE = "unable_to_delete";
	public static final String OBJECT_NOT_UPDATABLE = "object_not_updatable";
	public static final String USER_CREDENTIALS_MISMATCHED = "user_credentials_mismatched";
	public static final String UNKNOWN_ERROR = "unknown_error";
	public static final String UNKNOWN_ERROR_WITH_ID = "unknown_error_with_id";
	public static final String UNKONWN_ERROR_INSERT = "unkonwn_error_insert";
	public static final String TOKEN_EXPIRED = "token_expired";
	public static final String UNKNOWN_TOKEN = "unknown_token";
	public static final String ALREADY_EXISTS = "already_exists";
	public static final String VERSION_MISMATCH = "version_mismatch";
	public static final String CANNOT_CHANGE_PREF = "cannot_change_pref";
	public static final String UNABLE_TO_CREAT_OBJECT = "unable_to_create_object";
	public static final String FORBIDDEN_RESOURCE = "forbidden_resource";
	public static final String STORAGE_NOT_ACTIVE = "storage_not_active";
	public static final String FIELD_MANDATORY = "field_mandatory";
	public static final String VALUE_NOT_ALLOWED = "value_not_allowed";

	public DataMessageResourceService() {

		super(Map.of(Locale.ENGLISH, ResourceBundle.getBundle("messages", Locale.ENGLISH)));
	}

	@Override
	public Mono<String> getMessage(String messageId) {

		Mono<Locale> locale = SecurityContextUtil.getUsersLocale();

		return locale.flatMap(l -> {
			var x = this.bundleMap.get(l);

			if (x == null)
				x = this.bundleMap.get(Locale.forLanguageTag(l.getLanguage()));

			return x == null ? Mono.empty() : Mono.just(x);
		})
		        .defaultIfEmpty(this.bundleMap.get(Locale.ENGLISH))
		        .map(e -> e.getString(e.containsKey(messageId) ? messageId : UKNOWN_ERROR));
	}
}
