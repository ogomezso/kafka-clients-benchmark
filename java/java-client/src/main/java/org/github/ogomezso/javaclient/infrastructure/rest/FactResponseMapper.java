package org.github.ogomezso.javaclient.infrastructure.rest;


import org.github.ogomezso.javaclient.domain.model.ChuckFact;
import org.github.ogomezso.javaclient.infrastructure.rest.model.ChuckFactResponse;

class FactResponseMapper {

  ChuckFactResponse toResponse(ChuckFact fact){
    return ChuckFactResponse.builder()
        .fact(fact.getFact())
        .timestamp(fact.getTimestamp())
        .build();
  }
}
