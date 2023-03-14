package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.github.ogomezso.springkafka.infrastructure.model.ChuckFactMsg;
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
