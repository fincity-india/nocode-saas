package com.fincity.security.service;

import java.util.HashMap;
import java.util.Map;

import org.jooq.types.ULong;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fincity.nocode.kirun.engine.util.string.StringFormatter;
import com.fincity.saas.common.security.jwt.ContextAuthentication;
import com.fincity.saas.common.security.util.SecurityContextUtil;
import com.fincity.saas.commons.exeception.GenericException;
import com.fincity.saas.commons.jooq.service.AbstractJOOQUpdatableDataService;
import com.fincity.saas.commons.model.condition.AbstractCondition;
import com.fincity.security.dao.AppDAO;
import com.fincity.security.dto.App;
import com.fincity.security.jooq.tables.records.SecurityAppRecord;
import com.fincity.security.util.ULongUtil;

import reactor.core.publisher.Mono;

@Service
public class AppService extends AbstractJOOQUpdatableDataService<SecurityAppRecord, ULong, App, AppDAO> {

	private static final String APP = "APP";

	@Autowired
	private ClientService clientService;

	@Autowired
	private SecurityMessageResourceService messageResourceService;
	
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_CREATE')")
	@Override
	public Mono<App> create(App entity) {
		return super.create(entity);
	}
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_UPDATE')")
	@Override
	public Mono<App> update(App entity) {
		return super.update(entity);
	}
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_UPDATE')")
	@Override
	public Mono<App> update(ULong key, Map<String, Object> fields) {
		return super.update(key, fields);
	}
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_READ')")
	@Override
	public Mono<App> read(ULong id) {
		return super.read(id);
	}
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_READ')")
	@Override
	public Mono<Page<App>> readPageFilter(Pageable pageable, AbstractCondition condition) {
		return super.readPageFilter(pageable, condition);
	}
	
	@PreAuthorize("hasAuthority('Authorities.APPBUILDER.Application_DELETE')")
	@Override
	public Mono<Integer> delete(ULong id) {
		return super.delete(id);
	}

	@Override
	protected Mono<App> updatableEntity(App entity) {

		return ((AppService) AopContext.currentProxy()).read(entity.getId())
		        .flatMap(existing -> SecurityContextUtil.getUsersContextAuthentication()
		                .flatMap(ca ->
						{

			                existing.setAppName(entity.getAppName());

			                if (ContextAuthentication.CLIENT_TYPE_SYSTEM.equals(ca.getClientTypeCode()))
				                return Mono.just(existing);

			                return clientService.isBeingManagedBy(ULongUtil.valueOf(ca.getUser()
			                        .getClientId()), existing.getClientId())
			                        .flatMap(managed ->
									{
				                        if (managed.booleanValue())
					                        return Mono.just(existing);

				                        return messageResourceService
				                                .getMessage(SecurityMessageResourceService.OBJECT_NOT_FOUND)
				                                .flatMap(msg -> Mono
				                                        .error(() -> new GenericException(HttpStatus.NOT_FOUND,
				                                                StringFormatter.format(msg, APP, entity.getId()))));
			                        });

		                }));
	}

	@Override
	protected Mono<Map<String, Object>> updatableFields(ULong key, Map<String, Object> fields) {

		return ((AppService) AopContext.currentProxy()).read(key)
		        .flatMap(existing -> SecurityContextUtil.getUsersContextAuthentication()
		                .flatMap(ca ->
						{

			                Map<String, Object> newMap = new HashMap<>();
			                newMap.put("appName", fields.get("appName"));

			                if (ContextAuthentication.CLIENT_TYPE_SYSTEM.equals(ca.getClientTypeCode()))
				                return Mono.just(newMap);

			                return clientService.isBeingManagedBy(ULongUtil.valueOf(ca.getUser()
			                        .getClientId()), existing.getClientId())
			                        .flatMap(managed ->
									{
				                        if (managed.booleanValue())
					                        return Mono.just(newMap);

				                        return messageResourceService
				                                .getMessage(SecurityMessageResourceService.OBJECT_NOT_FOUND)
				                                .flatMap(msg -> Mono
				                                        .error(() -> new GenericException(HttpStatus.NOT_FOUND,
				                                                StringFormatter.format(msg, APP, key))));
			                        });

		                }));
	}

}
