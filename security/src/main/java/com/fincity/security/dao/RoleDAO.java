package com.fincity.security.dao;

import static com.fincity.security.jooq.tables.SecurityApp.SECURITY_APP;
import static com.fincity.security.jooq.tables.SecurityClient.SECURITY_CLIENT;
import static com.fincity.security.jooq.tables.SecurityClientPackage.SECURITY_CLIENT_PACKAGE;
import static com.fincity.security.jooq.tables.SecurityPackage.SECURITY_PACKAGE;
import static com.fincity.security.jooq.tables.SecurityPackageRole.SECURITY_PACKAGE_ROLE;
import static com.fincity.security.jooq.tables.SecurityPermission.SECURITY_PERMISSION;
import static com.fincity.security.jooq.tables.SecurityRole.SECURITY_ROLE;
import static com.fincity.security.jooq.tables.SecurityRolePermission.SECURITY_ROLE_PERMISSION;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.jooq.Condition;
import org.jooq.DeleteQuery;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DSL;
import org.jooq.types.ULong;
import org.springframework.stereotype.Component;

import com.fincity.saas.common.security.jwt.ContextAuthentication;
import com.fincity.saas.common.security.util.SecurityContextUtil;
import com.fincity.security.dto.Role;
import com.fincity.security.jooq.tables.records.SecurityRolePermissionRecord;
import com.fincity.security.jooq.tables.records.SecurityRoleRecord;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Component
public class RoleDAO extends AbstractClientCheckDAO<SecurityRoleRecord, ULong, Role> {

	public RoleDAO() {
		super(Role.class, SECURITY_ROLE, SECURITY_ROLE.ID);
	}

	@Override
	protected Field<ULong> getClientIDField() {
		return SECURITY_ROLE.CLIENT_ID;
	}

	public Mono<ULong> getClientIdFromRoleAndPermission(ULong roleId, ULong permissionId) {

		return Mono.from(

		        this.dslContext.select(SECURITY_CLIENT_PACKAGE.CLIENT_ID)
		                .from(SECURITY_ROLE_PERMISSION)
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_PACKAGE_ROLE.ROLE_ID.eq(SECURITY_ROLE_PERMISSION.ROLE_ID))
		                .leftJoin(SECURITY_CLIENT_PACKAGE)
		                .on(SECURITY_CLIENT_PACKAGE.PACKAGE_ID.eq(SECURITY_PACKAGE_ROLE.PACKAGE_ID))
		                .where(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId)
		                        .and(SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)))
		                .limit(1))
		        .map(Record1::value1);

	}

	public Mono<ULong> getClientIdFromRole(ULong roleId) {

		return Mono.from(

		        this.dslContext.select(SECURITY_ROLE.CLIENT_ID)
		                .from(SECURITY_ROLE)
		                .where(SECURITY_ROLE.ID.eq(roleId))
		                .limit(1))
		        .map(Record1::value1);
	}

	public Mono<ULong> getClientIdFromPermission(ULong permissionId) {

		return Mono.from(

		        this.dslContext.select(SECURITY_PERMISSION.CLIENT_ID)
		                .from(SECURITY_PERMISSION)
		                .where(SECURITY_PERMISSION.ID.eq(permissionId)))
		        .map(Record1::value1);
	}

	public Mono<Integer> addPermission(ULong roleId, ULong permissionId) {

		return Mono.from(

		        this.dslContext
		                .insertInto(SECURITY_ROLE_PERMISSION, SECURITY_ROLE_PERMISSION.ROLE_ID,
		                        SECURITY_ROLE_PERMISSION.PERMISSION_ID)
		                .values(roleId, permissionId));

	}

	public Mono<Boolean> checkPermissionAvailableForGivenRole(ULong roleId, ULong permissionId) {

		Condition rolePermissionCondition = SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)
		        .and(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId));

		Condition roleCondition = SECURITY_ROLE.ID.eq(roleId);

		Condition packageCondition = SECURITY_PACKAGE.BASE.eq((byte) 1);

		return Mono.from(

		        this.dslContext.select(SECURITY_ROLE.CLIENT_ID)
		                .from(SECURITY_ROLE)
		                .leftJoin(SECURITY_ROLE_PERMISSION)
		                .on(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(SECURITY_ROLE.ID))
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_ROLE.ID.eq(SECURITY_PACKAGE_ROLE.ROLE_ID))
		                .leftJoin(SECURITY_PACKAGE)
		                .on(SECURITY_PACKAGE.ID.eq(SECURITY_PACKAGE_ROLE.PACKAGE_ID))
		                .leftJoin(SECURITY_CLIENT_PACKAGE)
		                .on(SECURITY_CLIENT_PACKAGE.PACKAGE_ID.eq(SECURITY_PACKAGE.ID))
		                .leftJoin(SECURITY_CLIENT)
		                .on(SECURITY_CLIENT.ID.eq(SECURITY_PACKAGE.CLIENT_ID))
		                .where(rolePermissionCondition.or(packageCondition)
		                        .or(roleCondition))
		                .limit(1))
		        .map(Record1::value1)
		        .map(value -> value.intValue() > 0);

	}

	public Mono<Set<ULong>> fetchPermissionsFromRole(ULong roleId) {

		Set<ULong> permissionList = new HashSet<>();

		Flux.from(

		        this.dslContext.select(SECURITY_ROLE_PERMISSION.PERMISSION_ID)
		                .from(SECURITY_ROLE_PERMISSION)
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(SECURITY_PACKAGE_ROLE.ROLE_ID))
		                .where(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId)))
		        .map(Record1::value1)
		        .map(permissionList::add);

		return Mono.just(permissionList);
	}

	public Mono<Integer> removePermissionFromRole(ULong roleId, ULong permissionId) {

		DeleteQuery<SecurityRolePermissionRecord> query = this.dslContext.deleteQuery(SECURITY_ROLE_PERMISSION);

		query.addConditions(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId)
		        .and(SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)));

		return Mono.from(query);
	}

	public Mono<Boolean> checkPermissionBelongsToBasePackage(ULong roleId, ULong permissionId) {

		Condition rolePermissionCondition = SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)
		        .and(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId));

		Condition packageCondition = SECURITY_PACKAGE.BASE.eq((byte) 1);

		return Mono.from(

		        this.dslContext.select(SECURITY_ROLE.CLIENT_ID)
		                .from(SECURITY_ROLE)
		                .leftJoin(SECURITY_ROLE_PERMISSION)
		                .on(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(SECURITY_ROLE.ID))
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_ROLE.ID.eq(SECURITY_PACKAGE_ROLE.ROLE_ID))
		                .leftJoin(SECURITY_PACKAGE)
		                .on(SECURITY_PACKAGE.ID.eq(SECURITY_PACKAGE_ROLE.PACKAGE_ID))
		                .where(rolePermissionCondition.and(packageCondition))
		                .limit(1))
		        .map(Record1::value1)
		        .map(value -> value.intValue() > 0);

	}

	public Mono<Set<ULong>> getClientListFromAssignedRoleAndPermission(ULong roleId, ULong permissionId) {

		Set<ULong> clientList = new HashSet<>();

		Flux.from(

		        this.dslContext.selectDistinct(SECURITY_CLIENT_PACKAGE.CLIENT_ID)
		                .from(SECURITY_ROLE_PERMISSION)
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_PACKAGE_ROLE.ROLE_ID.eq(SECURITY_ROLE_PERMISSION.ROLE_ID))
		                .leftJoin(SECURITY_CLIENT_PACKAGE)
		                .on(SECURITY_CLIENT_PACKAGE.PACKAGE_ID.eq(SECURITY_PACKAGE_ROLE.PACKAGE_ID))
		                .where(SECURITY_ROLE_PERMISSION.ROLE_ID.eq(roleId)
		                        .and(SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)))

		)
		        .map(Record1::value1)
		        .toIterable()
		        .forEach(clientList::add);

		return Mono.just(clientList);

	}

	public Mono<Set<ULong>> getClientListFromAnotherRole(ULong roleId, ULong permissionId, Set<ULong> clientList) {

		Set<ULong> filteredClientList = new HashSet<>();

		Set<ULong> differentRoleClientList = new HashSet<>();

		Flux.from(

		        this.dslContext.selectDistinct(SECURITY_CLIENT_PACKAGE.CLIENT_ID)
		                .from(SECURITY_ROLE_PERMISSION)
		                .leftJoin(SECURITY_PACKAGE_ROLE)
		                .on(SECURITY_PACKAGE_ROLE.ROLE_ID.eq(SECURITY_ROLE_PERMISSION.ROLE_ID))
		                .leftJoin(SECURITY_CLIENT_PACKAGE)
		                .on(SECURITY_CLIENT_PACKAGE.PACKAGE_ID.eq(SECURITY_PACKAGE_ROLE.PACKAGE_ID))
		                .where(SECURITY_ROLE_PERMISSION.ROLE_ID.ne(roleId)
		                        .and(SECURITY_ROLE_PERMISSION.PERMISSION_ID.eq(permissionId)))

		)
		        .map(Record1::value1)
		        .toIterable()
		        .forEach(differentRoleClientList::add);

		Stream<ULong> filterStream = clientList.stream()
		        .filter(client -> !differentRoleClientList.contains(client));

		filterStream.forEach(filteredClientList::add);

		return Mono.just(filteredClientList);
	}

	@Override
	protected Mono<Tuple2<SelectJoinStep<Record>, SelectJoinStep<Record1<Integer>>>> getSelectJointStep() {

		return SecurityContextUtil.getUsersContextAuthentication()
		        .map(ca ->
				{

			        var cAlias = SECURITY_CLIENT.as("codeClient");

			        SelectJoinStep<Record> mainQuery = dslContext.select(Arrays.asList(table.fields()))
			                .select(DSL
			                        .replace(DSL.concat("Authorities.", DSL.concat(
			                                DSL.if_(SECURITY_APP.APP_CODE.isNull(), "",
			                                        DSL.concat(DSL.upper(SECURITY_APP.APP_CODE), ".")),
			                                DSL.if_(cAlias.CODE.eq("SYSTEM"), DSL.concat("ROLE_", SECURITY_ROLE.NAME),
			                                        DSL.concat(DSL.concat(cAlias.CODE, "_ROLE_"),
			                                                SECURITY_ROLE.NAME)))),
			                                " ", "_")
			                        .as("AUTHORITY"))
			                .from(table)
			                .leftJoin(cAlias)
			                .on(cAlias.ID.eq(SECURITY_ROLE.CLIENT_ID))
			                .leftJoin(SECURITY_APP)
			                .on(SECURITY_APP.ID.eq(SECURITY_ROLE.APP_ID));

			        SelectJoinStep<Record1<Integer>> countQuery = dslContext.select(DSL.count())
			                .from(table);

			        if (ca.getClientTypeCode()
			                .equals(ContextAuthentication.CLIENT_TYPE_SYSTEM))
				        return Tuples.of(mainQuery, countQuery);

			        return this.addJoinCondition(mainQuery, countQuery, this.getClientIDField());
		        });
	}
}