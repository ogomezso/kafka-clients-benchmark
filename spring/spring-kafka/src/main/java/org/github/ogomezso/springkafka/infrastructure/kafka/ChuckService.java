package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.domain.ChuckFactPort;
import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.github.ogomezso.springkafka.infrastructure.model.chuck.ChuckFactMsg;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class ChuckService implements ChuckAdapter {

  private final ChuckProducer chuckProducer;
  private final ChuckFactPort chuckFactPort;
  private final FactMapper mapper;
  private final ObjectMapper objectMapper;

  @Override
  public ChuckFact sendFact() throws JsonProcessingException {
    ChuckFact fact = chuckFactPort.buildFact();
    chuckProducer.sendFact(objectMapper.writeValueAsString(fact));
    return fact;
  }

  @Override
  public ChuckFact SendAvroFact() {
    ChuckFact fact = chuckFactPort.buildFact();
    ChuckFactMsg factMsg = mapper.toAvro(fact);
    chuckProducer.sendFact(factMsg);
    return fact;
  }
}
