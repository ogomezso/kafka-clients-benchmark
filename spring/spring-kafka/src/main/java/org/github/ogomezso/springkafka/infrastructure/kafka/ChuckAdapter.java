package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChuckAdapter {

  ChuckFact sendFact() throws JsonProcessingException;
  ChuckFact SendAvroFact();
}
