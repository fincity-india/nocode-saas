package com.fincity.saas.commons.mongo.service;

import static com.fincity.nocode.reactor.util.FlatMapUtil.flatMapMono;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fincity.saas.commons.mongo.document.Function;
import com.fincity.saas.commons.mongo.repository.FunctionRepository;

import reactor.core.publisher.Mono;

@Service
public class FunctionService extends AbstractOverridableDataServcie<Function, FunctionRepository> {

	
	public FunctionService() {
		super(Function.class);
	}


	@Override
	protected Mono<Function> updatableEntity(Function entity) {
		
		return flatMapMono(

		        () -> this.read(entity.getId()),

		        existing ->
				{
			        if (existing.getVersion() != entity.getVersion())
				        return this.messageResourceService.throwMessage(HttpStatus.PRECONDITION_FAILED,
				                AbstractMongoMessageResourceService.VERSION_MISMATCH);

			        existing.setDefinition(entity.getDefinition());
			        
			        existing.setVersion(existing.getVersion() + 1);

			        return Mono.just(existing);
		        });
	}
}