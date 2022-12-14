package com.fincity.saas.core.service;

import static com.fincity.nocode.reactor.util.FlatMapUtil.flatMapMono;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fincity.nocode.kirun.engine.json.schema.Schema;
import com.fincity.saas.commons.mongo.service.AbstractMongoMessageResourceService;
import com.fincity.saas.commons.mongo.service.AbstractOverridableDataService;
import com.fincity.saas.commons.util.UniqueUtil;
import com.fincity.saas.core.document.Storage;
import com.fincity.saas.core.repository.StorageRepository;

import reactor.core.publisher.Mono;

@Service
public class StorageService extends AbstractOverridableDataService<Storage, StorageRepository> {

	public static final String CACHE_NAME_STORAGE_SCHEMA = "storageSchema";

	protected StorageService() {
		super(Storage.class);
	}

	@Override
	public Mono<Storage> create(Storage entity) {

		entity.setUniqueName(UniqueUtil.uniqueName(32, entity.getAppCode(), entity.getClientCode(), entity.getName()));

		return super.create(entity);
	}

	@Override
	public Mono<Storage> update(Storage entity) {

		return super.update(entity).flatMap(uped -> this.cacheService.evict(CACHE_NAME_STORAGE_SCHEMA, uped.getId())
		        .map(e -> uped));
	}

	@Override
	public Mono<Boolean> delete(String id) {

		return super.delete(id).flatMap(del -> this.cacheService.evict(CACHE_NAME_STORAGE_SCHEMA, id)
		        .map(e -> del));
	}

	@Override
	protected Mono<Storage> updatableEntity(Storage entity) {
		return flatMapMono(

		        () -> this.read(entity.getId()),

		        existing ->
				{
			        if (existing.getVersion() != entity.getVersion())
				        return this.messageResourceService.throwMessage(HttpStatus.PRECONDITION_FAILED,
				                AbstractMongoMessageResourceService.VERSION_MISMATCH);

			        existing.setSchema(entity.getSchema())
			                .setIsAudited(entity.getIsAudited())
			                .setIsVersioned(entity.getIsVersioned())
			                .setCreateAuth(entity.getCreateAuth())
			                .setReadAuth(entity.getReadAuth())
			                .setUpdateAuth(entity.getUpdateAuth())
			                .setDeleteAuth(entity.getDeleteAuth());

			        existing.setVersion(existing.getVersion() + 1);

			        return Mono.just(existing);
		        });
	}

	public Mono<Schema> getSchema(Storage storage) {

		return cacheService.cacheEmptyValueOrGet(CACHE_NAME_STORAGE_SCHEMA,
		        () -> Mono.just(this.objectMapper.convertValue(storage.getSchema(), Schema.class)), storage.getId());
	}
}
