package com.fincity.saas.core.functions;

import java.util.List;
import java.util.Map;

import com.fincity.nocode.kirun.engine.function.reactive.AbstractReactiveFunction;
import com.fincity.nocode.kirun.engine.json.schema.Schema;
import com.fincity.nocode.kirun.engine.model.Event;
import com.fincity.nocode.kirun.engine.model.EventResult;
import com.fincity.nocode.kirun.engine.model.FunctionOutput;
import com.fincity.nocode.kirun.engine.model.FunctionSignature;
import com.fincity.nocode.kirun.engine.model.Parameter;
import com.fincity.nocode.kirun.engine.runtime.reactive.ReactiveFunctionExecutionParameters;
import com.fincity.saas.core.service.connection.appdata.AppDataService;
import com.google.gson.JsonPrimitive;

import reactor.core.publisher.Mono;

public class DeleteStorageObject extends AbstractReactiveFunction {

	private static final String DATA_OBJECT_ID = "dataObjectId";

	private static final String EVENT_RESULT = "result";

	private static final String FUNCTION_NAME = "DeleteStorage";

	private static final String NAME_SPACE = "CoreServices";

	private static final String STORAGE_NAME = "storageName";

	private AppDataService appDataService;

	public DeleteStorageObject(AppDataService appDataService) {
		this.appDataService = appDataService;
	}

	public AppDataService getAppDataService() {
		return appDataService;
	}

	@Override
	public FunctionSignature getSignature() {

		Event event = new Event().setName(Event.OUTPUT)
		        .setParameters(Map.of(EVENT_RESULT, Schema.ofAny(EVENT_RESULT)));

		Event errorEvent = new Event().setName(Event.ERROR)
		        .setParameters(Map.of(EVENT_RESULT, Schema.ofAny(EVENT_RESULT)));

		return new FunctionSignature().setName(FUNCTION_NAME)
		        .setNamespace(NAME_SPACE)
		        .setParameters(Map.of(STORAGE_NAME, Parameter.of(STORAGE_NAME, Schema.ofString(STORAGE_NAME)),
		                DATA_OBJECT_ID, Parameter.of(DATA_OBJECT_ID, Schema.ofString(DATA_OBJECT_ID))))
		        .setEvents(Map.of(event.getName(), event, errorEvent.getName(), errorEvent));
	}

	@Override
	protected Mono<FunctionOutput> internalExecute(ReactiveFunctionExecutionParameters context) {

		String storageName = context.getArguments()
		        .get(STORAGE_NAME)
		        .getAsString();

		String dataObjectId = context.getArguments()
		        .get(DATA_OBJECT_ID)
		        .getAsString();

		if (storageName == null)
			return Mono.just(new FunctionOutput(List.of(EventResult.of(Event.ERROR,
			        Map.of(Event.ERROR, new JsonPrimitive("Please provide the storage name."))))));

		if (dataObjectId == null)
			return Mono.just(new FunctionOutput(List.of(EventResult.of(Event.ERROR, Map.of(Event.ERROR,
			        new JsonPrimitive("Please provide the id for which delete needs to be performed."))))));

		
		return appDataService.delete(null, null, storageName, dataObjectId)
		        .map(result -> new FunctionOutput(List.of(EventResult.outputOf(
		                Map.of(EVENT_RESULT, new JsonPrimitive(dataObjectId + " deleted this data object"))))));
	}

}
