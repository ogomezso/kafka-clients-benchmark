package org.github.ogomezso.scs.infrastructure.kafka;

import org.github.ogomezso.scs.domain.model.ChuckFact;
import org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg;
import org.springframework.stereotype.Component;

@Component
public class FactMapper {
  ChuckFactMsg toAvro(ChuckFact fact){
    return ChuckFactMsg.newBuilder()
        .setFact(fact.getFact())
        .setId(fact.getId())
        .setTimestamp(fact.getTimestamp())
        .build();
  }
}
