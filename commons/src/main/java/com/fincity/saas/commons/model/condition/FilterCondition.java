package com.fincity.saas.commons.model.condition;

import java.util.List;

import com.fincity.saas.commons.util.StringUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import reactor.core.publisher.Flux;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class FilterCondition extends AbstractCondition {

	private static final long serialVersionUID = -4542270694019365457L;

	private String field;
	private FilterConditionOperator operator = FilterConditionOperator.EQUALS;
	private Object value; //NOSONAR
	private Object toValue; //NOSONAR
	private List<Object> multiValue; //NOSONAR
	private boolean isValueField = false;
	private boolean isToValueField = false;

	@Override
	public Flux<AbstractCondition> findConditionWithField(String fieldName) {

		if (StringUtil.safeEquals(field, fieldName))
			return Flux.just(this);
		
		return Flux.empty();
	}
}
