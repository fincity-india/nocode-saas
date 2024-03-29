package com.fincity.security.controller;

import java.util.List;

import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincity.saas.commons.jooq.controller.AbstractJOOQUpdatableDataController;
import com.fincity.security.dao.PackageDAO;
import com.fincity.security.dto.Package;
import com.fincity.security.dto.Role;
import com.fincity.security.jooq.tables.records.SecurityPackageRecord;
import com.fincity.security.service.PackageService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/security/packages")
public class PackageController
        extends AbstractJOOQUpdatableDataController<SecurityPackageRecord, ULong, Package, PackageDAO, PackageService> {

	@Autowired
	private PackageService packageService;

	
	@GetMapping("/{packageId}/assignRole/{roleId}")
	public Mono<ResponseEntity<Boolean>> assignRole(@PathVariable ULong packageId, @PathVariable ULong roleId) {

		return packageService.assignRoleToPackage(packageId, roleId)
		        .map(ResponseEntity::ok);

	}

	@GetMapping("/{packageId}/removeRole/{roleId}")
	public Mono<ResponseEntity<Boolean>> removeRole(@PathVariable ULong packageId, @PathVariable ULong roleId) {

		return packageService.removeRoleFromPackage(packageId, roleId)
		        .map(ResponseEntity::ok);

	}
	
	@GetMapping("/availableRoles/{packageId}")
	public Mono<ResponseEntity<List<Role>>> getRolesFromPackage(@PathVariable ULong packageId) {
		return this.packageService.getRolesFromGivenPackage(packageId)
				.map(ResponseEntity::ok);
	}
}
