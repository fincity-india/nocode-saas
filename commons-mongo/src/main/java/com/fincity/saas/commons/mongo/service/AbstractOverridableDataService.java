package com.fincity.saas.commons.mongo.service;

import static com.fincity.nocode.reactor.util.FlatMapUtil.flatMapMono;
import static com.fincity.nocode.reactor.util.FlatMapUtil.flatMapMonoWithNull;
import static com.fincity.saas.commons.mongo.service.AbstractMongoMessageResourceService.FORBIDDEN_CREATE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fincity.nocode.reactor.util.FlatMapUtil;
import com.fincity.saas.commons.exeception.GenericException;
import com.fincity.saas.commons.model.condition.AbstractCondition;
import com.fincity.saas.commons.model.condition.ComplexCondition;
import com.fincity.saas.commons.model.condition.ComplexConditionOperator;
import com.fincity.saas.commons.model.condition.FilterCondition;
import com.fincity.saas.commons.model.condition.FilterConditionOperator;
import com.fincity.saas.commons.mongo.document.Version;
import com.fincity.saas.commons.mongo.model.AbstractOverridableDTO;
import com.fincity.saas.commons.mongo.model.ListResultObject;
import com.fincity.saas.commons.mongo.model.TransportObject;
import com.fincity.saas.commons.mongo.repository.IOverridableDataRepository;
import com.fincity.saas.commons.security.jwt.ContextAuthentication;
import com.fincity.saas.commons.security.jwt.ContextUser;
import com.fincity.saas.commons.security.service.FeignAuthenticationService;
import com.fincity.saas.commons.security.util.SecurityContextUtil;
import com.fincity.saas.commons.service.CacheService;
import com.fincity.saas.commons.util.LogUtil;
import com.fincity.saas.commons.util.StringUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public abstract class AbstractOverridableDataService<D extends AbstractOverridableDTO<D>, R extends IOverridableDataRepository<D>>
		extends AbstractMongoUpdatableDataService<String, D, R> {

	private static final String CLIENT_CODE = "clientCode";
	private static final String APP_CODE = "appCode";

	protected static final String CREATE = "CREATE";
	protected static final String UPDATE = "UPDATE";
	protected static final String READ = "READ";
	protected static final String DELETE = "DELETE";

	protected static final String CACHE_NAME = "Cache";

	@Autowired
	protected CacheService cacheService;

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected AbstractMongoMessageResourceService messageResourceService;

	@Autowired
	protected AbstractVersionService versionService;

	@Autowired
	protected FeignAuthenticationService securityService;

	@Autowired
	protected com.fincity.saas.commons.mongo.repository.InheritanceService inheritanceService;

	private static final Set<String> READ_LRO_PARAMETERS_IGNORE = Set.of(CLIENT_CODE, APP_CODE, "size", "page");

	protected static final TypeReference<Map<String, Object>> TYPE_REFERENCE_MAP = new TypeReference<Map<String, Object>>() {
	};

	protected AbstractOverridableDataService(Class<D> pojoClass) {
		super(pojoClass);
	}

	@Override
	public Mono<D> create(D entity) {

		@SuppressWarnings("unchecked")
		Mono<D> crtEnt = FlatMapUtil.flatMapMono(

				SecurityContextUtil::getUsersContextAuthentication,

				ca -> (entity.getClientCode() == null) ? Mono.just((D) entity.setClientCode(ca.getClientCode()))
						: Mono.just(entity),

				(ca, ent) -> this.checkIfExists(ent),

				(ca, ent, cent) -> this.accessCheck(ca, CREATE, ent, true),

				(ca, ent, cent, hasSecurity) -> hasSecurity.booleanValue() ? Mono.just(cent) : Mono.empty())
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.create"))
                .switchIfEmpty(messageResourceService.throwMessage(
                        msg -> new GenericException(HttpStatus.FORBIDDEN, msg), FORBIDDEN_CREATE,
                        this.getObjectName()));

		return FlatMapUtil.flatMapMonoWithNull(

				() -> crtEnt,

				this::getMergedSources,

				this::extractOverride,

				(cEntity, merged, overridden) -> super.create(overridden),

				(cEntity, merged, overridden,
						created) -> isVersionable()
								? versionService.create(new Version().setClientCode(cEntity.getClientCode())
										.setObjectName(entity.getName())
										.setObjectAppCode(entity.getAppCode())
										.setObjectType(this.getObjectName()
												.toUpperCase())
										.setVersionNumber(created.getVersion())
										.setMessage(entity.getMessage())
										.setObject(this.objectMapper.convertValue(entity, TYPE_REFERENCE_MAP)))
								: Mono.empty(),

				(cEntity, merged, overridden, created, version) -> this.read(created.getId()))
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.create"))
				.flatMap(this::evictRecursively)
                .switchIfEmpty(messageResourceService.throwMessage(
                        msg -> new GenericException(HttpStatus.FORBIDDEN, msg), FORBIDDEN_CREATE,
                        this.getObjectName()));
	}

	protected Mono<Boolean> accessCheck(ContextAuthentication ca, String method, D entity,
			boolean checkAppWriteAccess) {

		if (entity == null)
			return Mono.just(false);

		return FlatMapUtil.flatMapMono(
				() -> SecurityContextUtil.hasAuthority("Authorities." + this.getObjectName() + "_" + method,
						ca.getAuthorities()) ? Mono.just(true) : Mono.empty(),

				access -> {
					if (ca.getClientCode()
							.equals(entity.getClientCode()))
						return Mono.just(true);

					if (checkAppWriteAccess)
						return this.securityService.isBeingManaged(ca.getClientCode(), entity.getClientCode());
					else
						return this.inheritanceService
								.order(entity.getAppCode(), ca.getUrlClientCode(), ca.getClientCode())
								.map(e -> e.contains(ca.getClientCode()));
				},

				(access, managed) -> {

					if (!managed.booleanValue())
						return Mono.empty();

					return checkAppWriteAccess
							? this.securityService.hasWriteAccess(entity.getAppCode(), ca.getClientCode())
							: this.securityService.hasReadAccess(entity.getAppCode(), ca.getClientCode());
				})
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.accessCheck"))
				.defaultIfEmpty(false);
	}

	public String getObjectName() {
		return this.pojoClass.getSimpleName();
	}

	private Mono<D> checkIfExists(D cca) {

		return this.mongoTemplate.count(new Query(new Criteria().andOperator(

				Criteria.where("name")
						.is(cca.getName()),
				Criteria.where(APP_CODE)
						.is(cca.getAppCode()),
				Criteria.where(CLIENT_CODE)
						.is(cca.getClientCode())

		)), this.pojoClass)
                .flatMap(c -> c > 0
                        ? messageResourceService.throwMessage(msg -> new GenericException(HttpStatus.CONFLICT,
                                msg), AbstractMongoMessageResourceService.ALREADY_EXISTS, this.getObjectName(),
                                cca.getName())
                        : Mono.just(cca));
	}

	@Override
	public Mono<D> read(String id) {

		return FlatMapUtil.flatMapMonoWithNull(

				() -> super.read(id),

				entity -> SecurityContextUtil.getUsersContextAuthentication(),

				(entity, ca) -> this.accessCheck(ca, READ, entity, false),

				(entity, ca, hasAccess) -> hasAccess.booleanValue() ? this.getMergedSources(entity) : Mono.empty(),

				(entity, ca, hasAccess, merged) -> hasAccess.booleanValue() ? this.applyOverride(entity, merged)
						: Mono.empty())
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.read"))
                .switchIfEmpty(
                        this.messageResourceService.throwMessage(msg -> new GenericException(HttpStatus.NOT_FOUND,
                                msg ), AbstractMongoMessageResourceService.OBJECT_NOT_FOUND, this.getObjectName(), id));
	}

	public Mono<D> readInternal(String id) {

		return flatMapMonoWithNull(

				() -> super.read(id),

				this::getMergedSources,

				this::applyOverride)
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.readInternal"));
	}

	@Override
	public Mono<D> update(D entity) {

		Mono<D> crtEnt = flatMapMono(

				SecurityContextUtil::getUsersContextAuthentication,

				ca -> this.accessCheck(ca, UPDATE, entity, true),

				(ca, hasAccess) -> hasAccess.booleanValue() ? Mono.just(entity) : Mono.empty())
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.update"));

		return crtEnt.flatMap(e -> flatMapMonoWithNull(

				() -> this.getMergedSources(e),

				merged -> this.extractOverride(e, merged),

				(merged, overridden) -> super.update(overridden),

				(merged, overridden,
						created) -> isVersionable()
								? versionService.create(new Version().setClientCode(entity.getClientCode())
										.setObjectName(entity.getName())
										.setObjectAppCode(entity.getAppCode())
										.setObjectType(this.getObjectName()
												.toUpperCase())
										.setVersionNumber(created.getVersion())
										.setMessage(entity.getMessage())
										.setObject(this.objectMapper.convertValue(entity, TYPE_REFERENCE_MAP)))
								: Mono.empty(),

				(merged, overridden, created, version) -> this.read(created.getId()),

				(m, o, c, v, f) -> {

					this.evictRecursively(f)
							.subscribe();

					return Mono.just(f);
				}).contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.update")));
	}

	protected Mono<D> evictRecursively(D f) {

		cacheService.evictAll(this.getCacheName(f.getAppCode(), f.getName()))
				.subscribe();
		return Mono.just(f);
	}

	@Override
	public Mono<Boolean> delete(String id) {

		Mono<D> exists = this.repo.findById(id)
                .switchIfEmpty(messageResourceService.throwMessage(msg -> new GenericException(HttpStatus.NOT_FOUND,
                        msg), AbstractMongoMessageResourceService.OBJECT_NOT_FOUND, this.getObjectName(), id));

		return flatMapMono(

				() -> exists,

				entity -> this.repo.countByNameAndAppCodeAndBaseClientCode(entity.getName(), entity.getAppCode(),
						entity.getClientCode()),

				(entity, count) -> SecurityContextUtil.getUsersContextAuthentication(),

				(entity, count, ca) -> this.accessCheck(ca, DELETE, entity, true),

				(entity, count, ca, hasAccess) -> {

					if (!hasAccess.booleanValue())
						return Mono.empty();

					if (count > 0l)
                        return messageResourceService.throwMessage(msg -> new GenericException(HttpStatus.FORBIDDEN,
                                msg),AbstractMongoMessageResourceService.UNABLE_TO_DELETE, this.getObjectName(), id);

					cacheService.evict(this.getCacheName(entity.getAppCode(), entity.getName()), entity.getClientCode())
							.subscribe();
					return super.delete(id);
				}).contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.delete"))
                .switchIfEmpty(
                        this.messageResourceService.throwMessage(msg -> new GenericException(HttpStatus.NOT_FOUND,
                                msg),AbstractMongoMessageResourceService.UNABLE_TO_DELETE, this.getObjectName(), id));
	}

	protected Mono<D> getMergedSources(D entity) {

		if (entity == null)
			return Mono.empty();

		if (entity.getBaseClientCode() == null)
			return Mono.empty();

		Flux<D> x = Mono.just(entity)
				.expandDeep(e -> e.getBaseClientCode() == null ? Mono.empty()
						: this.repo.findOneByNameAndAppCodeAndClientCode(e.getName(), e.getAppCode(),
								e.getBaseClientCode()));

		return x.collectList()
				.flatMap(list -> {
					if (list.size() == 1)
						return Mono.empty();

					if (list.size() == 2)
						return Mono.just(list.get(1));

					Mono<D> current = Mono.just(list.get(list.size() - 2));

					for (int i = list.size() - 3; i >= 0; i--) {
						final int fi = i;
						current = current.flatMap(b -> list.get(fi)
								.applyActualOverride(b));
					}

					return current;
				});
	}

	protected boolean isVersionable() {
		return true;
	}

	protected Mono<D> extractOverride(D entity, D mergedSources) {
		if (entity == null)
			return Mono.empty();

		if (mergedSources == null)
			return Mono.just(entity);

		return entity.makeActualOverride(mergedSources);
	}

	protected Mono<D> applyOverride(D entity, D mergedSources) {
		if (entity == null)
			return Mono.empty();

		if (mergedSources == null)
			return Mono.just(entity);

		return entity.applyActualOverride(mergedSources);
	}

	@Override
	protected Mono<String> getLoggedInUserId() {

		return SecurityContextUtil.getUsersContextAuthentication()
				.map(ContextAuthentication::getUser)
				.map(ContextUser::getId)
				.map(Object::toString);
	}

	public Flux<D> readForTransport(String appCode, String clientCode, List<String> names) {

		if (StringUtil.safeIsBlank(appCode) || StringUtil.safeIsBlank((clientCode)))
            return this.messageResourceService.throwFluxMessage(msg -> new GenericException(HttpStatus.FORBIDDEN, msg),
                    AbstractMongoMessageResourceService.FORBIDDEN_APP_ACCESS, appCode);

		Mono<Tuple2<Boolean, String>> accessCheck = accessCheckForTransport(appCode, clientCode);

		LinkedMultiValueMap<String, String> mMap = new LinkedMultiValueMap<>();
		mMap.put(CLIENT_CODE, List.of(clientCode));
		mMap.put(APP_CODE, List.of(appCode));
		if (names != null && !names.isEmpty())
			mMap.put("name", names);

		return accessCheck.flatMap(e -> this.paramToConditionLRO(mMap, appCode))
				.flatMap(e -> this.filter(e.getT1()))
				.flatMapMany(e -> this.mongoTemplate.find(new Query(new Criteria().andOperator(e,
						new Criteria().orOperator(Criteria.where("notOverridable")
								.ne(Boolean.TRUE),
								Criteria.where(CLIENT_CODE)
										.is(clientCode)))),
						this.pojoClass, this.getCollectionName()))
				.flatMap(e -> this.readInternal(e.getId()))
				.filter(e -> e.getClientCode()
						.equals(clientCode));
	}

	private Mono<Tuple2<Boolean, String>> accessCheckForTransport(String appCode, String clientCode) {
		return FlatMapUtil.flatMapMono(

				SecurityContextUtil::getUsersContextAuthentication,

				ca -> {
					if (!ca.isAuthenticated())
						return Mono.empty();

					if (ca.isSystemClient())
						return Mono.just(Tuples.of(true, clientCode));

					if (clientCode == null || ca.getClientCode()
							.equals(clientCode))
						return this.securityService.hasReadAccess(appCode, ca.getClientCode())
								.map(e -> Tuples.of(e, ca.getClientCode()));

					return this.securityService.isBeingManaged(ca.getClientCode(), clientCode)
							.flatMap(e -> !e.booleanValue() ? Mono.empty()
									: this.securityService.hasReadAccess(appCode, clientCode))
							.map(e -> Tuples.of(e, clientCode));
				},

				(ca, access) -> access.getT1()
						.booleanValue() ? Mono.just(access) : Mono.empty())
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.accessCheckForTransport"))
                .switchIfEmpty(Mono.defer(() -> this.messageResourceService.throwMessage(
                        msg -> new GenericException(HttpStatus.FORBIDDEN, msg),
                        AbstractMongoMessageResourceService.FORBIDDEN_APP_ACCESS, appCode)));
	}

	protected String getCollectionName() {
		String cName = this.getObjectName();
		return Character.toLowerCase(cName.charAt(0)) + cName.substring(1);
	}

	public Mono<Page<ListResultObject>> readPageFilterLRO(Pageable pageable, MultiValueMap<String, String> params) { // NOSONAR

		final String appCode = params.getFirst(APP_CODE) == null ? "" : params.getFirst(APP_CODE);

		Mono<Tuple2<Boolean, String>> accessCheck = FlatMapUtil.flatMapMono(

				SecurityContextUtil::getUsersContextAuthentication,

				ca -> {
					if (!ca.isAuthenticated())
						return Mono.empty();

					String clientCode = params.getFirst(CLIENT_CODE);

					if (clientCode == null || ca.getClientCode()
							.equals(clientCode))
						return this.securityService.hasReadAccess(appCode, ca.getClientCode())
								.map(e -> Tuples.of(e, ca.getClientCode()));

					return this.securityService.isBeingManaged(ca.getClientCode(), clientCode)
							.flatMap(e -> !e.booleanValue() ? Mono.empty()
									: this.securityService.hasReadAccess(appCode, clientCode))
							.map(e -> Tuples.of(e, clientCode));
				},

				(ca, access) -> access.getT1()
						.booleanValue() ? Mono.just(access) : Mono.empty())
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.readPageFilterLRO"))
                .switchIfEmpty(Mono.defer(() -> this.messageResourceService.throwMessage(
                        msg -> new GenericException(HttpStatus.FORBIDDEN, msg),
                        AbstractMongoMessageResourceService.FORBIDDEN_APP_ACCESS, appCode)));

		Mono<Page<ListResultObject>> returnList = FlatMapUtil.flatMapMono(

				() -> accessCheck,

				ac -> paramToConditionLRO(params, appCode),

				(ac, tup) -> this.filter(tup.getT1()),

				(ac, tup, crit) -> this.mongoTemplate
						.find(new Query(new Criteria().andOperator(crit,
								new Criteria().orOperator(Criteria.where("notOverridable")
										.ne(Boolean.TRUE),
										Criteria.where(CLIENT_CODE)
												.is(ac.getT2()))))
								.with(pageable.getSort()), ListResultObject.class, this.getCollectionName())
						.collectList(),

				(ac, tup, crit, list) -> {

					Map<String, ListResultObject> things = new HashMap<>();

					String clientCode = tup.getT2()
							.isEmpty() ? null
									: tup.getT2()
											.get(tup.getT2()
													.size() - 1);

					for (ListResultObject lro : list) {

						if (!things.containsKey(lro.getName())) {
							things.put(lro.getName(), lro);
							continue;
						}

						if (lro.getClientCode()
								.equals(clientCode)) {
							things.put(lro.getName(), lro);
						}
					}

					List<ListResultObject> nList = filterBasedOnPageSize(pageable, list, things);

					return Mono.just((Page<ListResultObject>) new PageImpl<>(nList, pageable, list.size()));
				})
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.readPageFilterLRO"));

		return returnList.defaultIfEmpty(new PageImpl<>(List.of(), pageable, 0));
	}

	private List<ListResultObject> filterBasedOnPageSize(Pageable pageable, List<ListResultObject> list,
			Map<String, ListResultObject> things) {

		Set<String> ids = things.values()
				.stream()
				.map(ListResultObject::getId)
				.collect(Collectors.toSet());

		List<ListResultObject> nList = list.stream()
				.sequential()
				.filter(e -> ids.contains(e.getId()))
				.toList();

		int from = (int) pageable.getOffset();
		int to = (int) pageable.getOffset() + pageable.getPageSize();

		if (nList.size() > from)
			return nList.subList(from, to >= nList.size() ? nList.size() : to);

		return List.of();
	}

	private Mono<Tuple2<ComplexCondition, List<String>>> paramToConditionLRO(MultiValueMap<String, String> params,
			final String appCode) {

		return FlatMapUtil.flatMapMono(

				SecurityContextUtil::getUsersContextAuthentication,

				ca -> {
					if (params.containsKey(CLIENT_CODE) && !ca.isSystemClient())
						return this.securityService.isBeingManaged(ca.getClientCode(), params.getFirst(CLIENT_CODE));

					return Mono.just(Boolean.TRUE);
				},

				(ca, isBeingManaged) -> {

					if (!isBeingManaged.booleanValue())
						return Mono.empty();

					String cc = params.getFirst(CLIENT_CODE);
					return Mono.just(cc == null ? ca.getClientCode() : cc);
				},

				(ca, isBeingManaged, finClientCode) -> this.inheritanceService.order(appCode, ca.getClientCode(),
						finClientCode),

				(ca, isBeingManaged, finClientCode, inheritance) -> {

					List<AbstractCondition> conditions = new ArrayList<>();

					if (inheritance.size() == 1)
						conditions.add(new FilterCondition().setField(CLIENT_CODE)
								.setOperator(FilterConditionOperator.EQUALS)
								.setValue(inheritance.get(0)));
					else
						conditions.add(new FilterCondition().setField(CLIENT_CODE)
								.setOperator(FilterConditionOperator.IN)
								.setValue(inheritance.stream()
										.collect(Collectors.joining(","))));

					String applicationName = params.getFirst(APP_CODE);
					conditions.add(new FilterCondition().setField(APP_CODE)
							.setOperator(FilterConditionOperator.EQUALS)
							.setValue(applicationName));

					conditions.addAll(params.entrySet()
							.stream()
							.filter(e -> !READ_LRO_PARAMETERS_IGNORE.contains(e.getKey()))
							.filter(e -> Objects.nonNull(e.getValue()))
							.filter(e -> !e.getValue()
									.isEmpty())
							.map(e -> {
								FilterCondition fc = new FilterCondition().setField(e.getKey());
								if (e.getValue()
										.size() == 1)
									return fc.setOperator(FilterConditionOperator.STRING_LOOSE_EQUAL)
											.setValue(e.getValue()
													.get(0));
								List<Object> values = e.getValue()
										.stream()
										.map(Object.class::cast)
										.toList();
								return fc.setOperator(FilterConditionOperator.IN)
										.setMultiValue(values);
							})
							.toList());

					Tuple2<ComplexCondition, List<String>> tup = Tuples
							.of(new ComplexCondition().setConditions(conditions)
									.setOperator(ComplexConditionOperator.AND), inheritance);
					return Mono.just(tup);
				})
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.paramToConditionLRO"));
	}

	public Mono<D> read(String name, String appCode, String clientCode) {

		return FlatMapUtil.flatMapMonoWithNull(

				() -> Mono.just(clientCode),

				key -> cacheService.get(this.getCacheName(appCode, name), key)
						.map(this.pojoClass::cast),

				(key, cApp) -> Mono.justOrEmpty(cApp)
						.switchIfEmpty(Mono.defer(() -> SecurityContextUtil.getUsersContextAuthentication()
								.map(ContextAuthentication::getUrlClientCode)
								.defaultIfEmpty(clientCode)
								.flatMap(cc -> readIfExistsInBase(name, appCode, cc, clientCode)))),

				(key, cApp, dbApp) -> Mono.justOrEmpty(dbApp)
						.flatMap(da -> this.readInternal(da.getId())
								.map(this.pojoClass::cast)),

				(key, cApp, dbApp, mergedApp) -> {

					if (cApp == null && mergedApp == null)
						return Mono.empty();

					try {
						return Mono.just(this.pojoClass.getConstructor(this.pojoClass)
								.newInstance(cApp != null ? cApp : mergedApp));
                    } catch (Exception e) {

                        return this.messageResourceService.throwMessage(
                                msg -> new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, msg, e),
                                AbstractMongoMessageResourceService.UNABLE_TO_CREATE_OBJECT, this.getObjectName());
                    }
				},

				(key, cApp, dbApp, mergedApp, clonedApp) -> {

					if (clonedApp == null)
						return Mono.empty();

					if (cApp == null && mergedApp != null) {
						cacheService.put(this.getCacheName(appCode, name), mergedApp, key);
					}

					return this.applyChange(name, appCode, clientCode, clonedApp);
				})
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.read"));
	}

	protected Mono<D> readIfExistsInBase(String name, String appCode, String urlClientCode, String clientCode) {

		return FlatMapUtil.flatMapMono(() -> this.inheritanceService.order(appCode, urlClientCode, clientCode),

				clientCodes -> this.repo.findByNameAndAppCodeAndClientCodeIn(name, appCode, clientCodes)
						.collectList(),

				(clientCodes, lst) -> {
					if (lst.isEmpty())
						return Mono.empty();
					if (lst.size() == 1)
						return Mono.just(lst.get(0));

					for (D item : lst) {
						if (clientCode.equals(item.getClientCode()))
							return Mono.just(item);
					}

					return Mono.empty();
				},

				(clientCodes, lst, found) -> Mono.just(this.pojoClass.cast(found)))
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.readIfExistsInBase"));
	}

	protected Mono<D> applyChange(String name, String appCode, String clientCode, D object) { // NOSONAR

		return Mono.just(object);
	}

	protected String getCacheName(String appCode, String name) {

		return new StringBuilder(this.getObjectName()).append(CACHE_NAME)
				.append("_")
				.append(appCode)
				.append("_")
				.append(name)
				.toString();
	}

	@SuppressWarnings("unchecked")
	public Mono<D> createForClient(String id, String clientCode) {

		return flatMapMono(

				() -> this.readInternal(id),

				e -> this.create((D) e.setBaseClientCode(e.getClientCode())
						.setClientCode(clientCode)
						.setId(null))

		).contextWrite(Context.of(LogUtil.METHOD_NAME, "AbstractOverridableDataService.createForClient"));
	}

	public TransportObject makeTransportObject(Object entity) {
		return new TransportObject(this.getObjectName(),
				this.objectMapper.convertValue(this.pojoClass.cast(entity), TYPE_REFERENCE_MAP));
	}

	public D makeEntity(TransportObject transportObject) {

		if (!StringUtil.safeEquals(this.getObjectName(), transportObject.getObjectType()))
			return null;

		return this.objectMapper.convertValue(transportObject.getData(), this.pojoClass);
	}

	public Class<D> getPojoClass() {

		return this.pojoClass;
	}
}
