package com.fincity.saas.commons.mongo.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fincity.nocode.reactor.util.FlatMapUtil;
import com.fincity.saas.commons.model.condition.AbstractCondition;
import com.fincity.saas.commons.model.condition.ComplexCondition;
import com.fincity.saas.commons.model.condition.ComplexConditionOperator;
import com.fincity.saas.commons.model.condition.FilterCondition;
import com.fincity.saas.commons.model.dto.AbstractDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractMongoDataService<I extends Serializable, D extends AbstractDTO<I, I>, R extends ReactiveCrudRepository<D, I>> {

    @Autowired
    protected R repo;

    @Autowired
    protected ReactiveMongoTemplate mongoTemplate;

    protected Class<D> pojoClass;

    protected AbstractMongoDataService(Class<D> pojoClass) {

        this.pojoClass = pojoClass;
    }

    public Mono<D> create(D entity) {

        entity.setCreatedBy(null);
        entity.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return this.getLoggedInUserId()
                .map(e -> {
                    entity.setCreatedBy(e);
                    return entity;
                })
                .defaultIfEmpty(entity)
                .flatMap(e -> this.repo.save(e));

    }

    protected Mono<I> getLoggedInUserId() {
        return Mono.empty();
    }

    public Mono<D> read(I id) {
        return this.repo.findById(id);
    }

    public Mono<Page<D>> readPageFilter(Pageable pageable, AbstractCondition condition) {

        return FlatMapUtil.flatMapMono(

                () -> this.filter(condition),

                crit -> Mono.just((new Query(crit)).skip(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .with(pageable.getSort())),

                (crit, dataQuery) -> this.mongoTemplate.find(dataQuery, this.pojoClass)
                        .collectList(),

                (crit, dataQuery, list) -> Mono.just((new Query(crit)).with(pageable.getSort())),

                (crit, dataQuery, list, countQuery) -> this.mongoTemplate.count(countQuery, this.pojoClass),

                (crit, dataQuery, list, countQuery, count) -> Mono.just(new PageImpl<>(list, pageable, count)));
    }

    public Flux<D> readAllFilter(AbstractCondition condition) {
        return this.filter(condition)
                .flatMapMany(crit -> this.mongoTemplate.find(new Query(crit), this.pojoClass));
    }

    protected Mono<Criteria> filter(AbstractCondition condition) {

        if (condition == null)
            return Mono.just(new Criteria());

        Mono<Criteria> cond = null;
        if (condition instanceof ComplexCondition cc)
            cond = complexConditionFilter(cc);
        else
            cond = filterConditionFilter((FilterCondition) condition);

        return cond.map(c -> condition.isNegate() ? c.not() : c)
                .defaultIfEmpty(new Criteria());
    }

    private Mono<Criteria> filterConditionFilter(FilterCondition fc) {

        if (fc == null || fc.getField() == null || fc.getValue() == null)
            return Mono.empty();

        Criteria crit = Criteria.where(fc.getField());

        switch (fc.getOperator()) {
            case BETWEEN:
                return Mono.just(new Criteria().andOperator(crit.gte(fc.getValue()), crit.lte(fc.getToValue())));

            case EQUALS:
                return Mono.just(crit.is(fc.getValue()));

            case GREATER_THAN:
                return Mono.just(crit.gt(fc.getValue()));

            case GREATER_THAN_EQUAL:
                return Mono.just(crit.gte(fc.getValue()));

            case LESS_THAN:
                return Mono.just(crit.lt(fc.getValue()));

            case LESS_THAN_EQUAL:
                return Mono.just(crit.lte(fc.getValue()));

            case IS_FALSE:
                return Mono.just(crit.is(false));

            case IS_TRUE:
                return Mono.just(crit.is(true));

            case IS_NULL:
                return Mono.just(crit.isNull());

            case IN:
                return Mono.just(crit.in(this.multiFieldValue(fc.getValue(), fc.getMultiValue())));

            case LIKE:
                return Mono.just(crit.is(fc.getValue()));

            case STRING_LOOSE_EQUAL:
                return Mono.just(crit.regex(fc.getValue().toString()));

            default:
                return Mono.empty();
        }
    }

    private List<Object> multiFieldValue(Object objValue, List<Object> values) {

        if (values != null && !values.isEmpty())
            return values;

        if (objValue == null)
            return List.of();

        int from = 0;
        String iValue = objValue.toString()
                .trim();

        List<Object> obj = new ArrayList<>();
        for (int i = 0; i < iValue.length(); i++) { // NOSONAR
            // Having multiple continue statements is not confusing

            if (iValue.charAt(i) != ',')
                continue;

            if (i != 0 && iValue.charAt(i - 1) == '\\')
                continue;

            String str = iValue.substring(from, i)
                    .trim();
            if (str.isEmpty())
                continue;

            obj.add(str);
            from = i + 1;
        }

        return obj;

    }

    private Mono<Criteria> complexConditionFilter(ComplexCondition cc) {

        if (cc.getConditions() == null || cc.getConditions()
                .isEmpty())
            return Mono.empty();

        return Flux.concat(cc.getConditions()
                .stream()
                .map(this::filter)
                .toList())
                .collectList()
                .map(conds -> cc.getOperator() == ComplexConditionOperator.AND ? new Criteria().andOperator(conds)
                        : new Criteria().orOperator(conds));
    }

    public Mono<Boolean> delete(I id) {
        return this.repo.deleteById(id)
                .thenReturn(true);
    }
}
