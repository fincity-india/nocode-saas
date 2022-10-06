package com.fincity.security.dao;

import static com.fincity.security.jooq.tables.SecurityPackage.SECURITY_PACKAGE;
import static com.fincity.security.jooq.tables.SecurityPackageRole.SECURITY_PACKAGE_ROLE;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.types.ULong;
import org.springframework.stereotype.Component;

import com.fincity.security.dto.Package;
import com.fincity.security.jooq.tables.records.SecurityPackageRecord;

import reactor.core.publisher.Mono;

@Component
public class PackageDAO extends AbstractClientCheckDAO<SecurityPackageRecord, ULong, com.fincity.security.dto.Package> {

	public PackageDAO() {
		super(Package.class, SECURITY_PACKAGE, SECURITY_PACKAGE.ID);
	}

	@Override
	protected Field<ULong> getClientIDField() {

		return SECURITY_PACKAGE.CLIENT_ID;
	}

	public Mono<ULong> getClientIdFromPackage(ULong packageId) {
		return Mono.from(

		        this.dslContext.select(SECURITY_PACKAGE.CLIENT_ID)
		                .from(SECURITY_PACKAGE)
		                .where(SECURITY_PACKAGE.ID.eq(packageId))
		                .limit(1)

		)
		        .map(Record1::value1);
	}

	public Mono<Boolean> checkRoleApplicableForPackage(ULong packageId, ULong roleId) {
		return Mono.just(this.dslContext.selectFrom(SECURITY_PACKAGE_ROLE)
		        .where(SECURITY_PACKAGE_ROLE.PACKAGE_ID.eq(packageId)
		                .and(SECURITY_PACKAGE_ROLE.ROLE_ID.eq(roleId)))
		        .execute() > 0);
	}
}
