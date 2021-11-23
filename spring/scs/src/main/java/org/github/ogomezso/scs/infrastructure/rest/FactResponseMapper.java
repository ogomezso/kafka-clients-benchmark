package org.github.ogomezso.scs.infrastructure.rest;

import org.github.ogomezso.scs.domain.model.ChuckFact;
import org.github.ogomezso.scs.infrastructure.rest.model.ChuckFactResponse;
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
