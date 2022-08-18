package com.fincity.security.service;

import java.io.Serializable;
import java.util.Map;

import org.jooq.UpdatableRecord;

import com.fincity.security.dao.AbstractUpdatableDAO;
import com.fincity.security.dto.AbstractUpdatableDTO;

import reactor.core.publisher.Mono;

public abstract class AbstractUpdatableDataService<R extends UpdatableRecord<R>, I extends Serializable, D extends AbstractUpdatableDTO<I, I>, O extends AbstractUpdatableDAO<R, I, D>>
        extends AbstractDataService<R, I, D, O> {

	public Mono<D> update(I key, Map<String, Object> fields) {

		return this.updatableFields(fields)
		        .flatMap(updatableFields -> this.getLoggedInUserId()
		                .map(e ->
						{
			                updatableFields.remove("id");
			                updatableFields.put("updatedBy", e);
			                return updatableFields;
		                })
		                .defaultIfEmpty(updatableFields)
		                .flatMap(f -> this.dao.update(key, f)));
	}

	public Mono<D> update(D entity) {

		return this.updatableEntity(entity)
		        .flatMap(updateableEntity -> this.getLoggedInUserId()
		                .map(e ->
						{
			                updateableEntity.setUpdatedBy(e);
			                return updateableEntity;
		                })
		                .defaultIfEmpty(updateableEntity)
		                .flatMap(ent -> this.dao.update(ent)));
	}

	protected abstract Mono<D> updatableEntity(D entity);

	protected abstract Mono<Map<String, Object>> updatableFields(Map<String, Object> fields);

}
