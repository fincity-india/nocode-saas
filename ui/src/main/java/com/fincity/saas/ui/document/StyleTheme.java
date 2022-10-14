package com.fincity.saas.ui.document;

import java.util.Map;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fincity.nocode.reactor.util.FlatMapUtil;
import com.fincity.saas.ui.util.DifferenceApplicator;
import com.fincity.saas.ui.util.DifferenceExtractor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import reactor.core.publisher.Mono;

@Data
@EqualsAndHashCode(callSuper = true)
@Document
@CompoundIndex(def = "{'applicationName': 1, 'name': 1, 'clientCode': 1, 'styleName': 1}", name = "stylethemeFilteringIndex")
@Accessors(chain = true)
public class StyleTheme extends AbstractUIDTO<StyleTheme> {

	private static final long serialVersionUID = 4355909627072800292L;

	private String styleName;
	private Map<String, Map<String, String>> variables;

	@SuppressWarnings("unchecked")
	@Override
	public Mono<StyleTheme> applyOverride(StyleTheme base) {

		if (base != null) {

			return FlatMapUtil.flatMapMonoWithNull(

			        () -> DifferenceApplicator.apply(this.variables, base.variables),

			        (v) ->
					{
				        this.variables = (Map<String, Map<String, String>>) v;
				        return Mono.just(this);
			        });
		}
		return Mono.just(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Mono<StyleTheme> makeOverride(StyleTheme base) {

		if (base == null)
			return Mono.just(this);

		return Mono.just(this)
		        .flatMap(a -> DifferenceExtractor.extract(a.variables, base.variables)
		                .map(e ->
						{
			                a.setVariables((Map<String, Map<String, String>>) e);
			                return a;
		                }));

	}
}