package org.github.ogomezso.springkafka.infrastructure.rest;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.github.ogomezso.springkafka.infrastructure.rest.model.ChuckFactResponse;
import org.springframework.stereotype.Component;

@Component
public class FactResponseMapper {

  ChuckFactResponse toResponse(ChuckFact fact){
    return ChuckFactResponse.builder()
        .fact(fact.getFact())
        .timestamp(fact.getTimestamp())
        .build();
  }
}
