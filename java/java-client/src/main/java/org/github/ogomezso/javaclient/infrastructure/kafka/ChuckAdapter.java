package org.github.ogomezso.javaclient.infrastructure.kafka;


import org.github.ogomezso.javaclient.domain.model.ChuckFact;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChuckAdapter {

  ChuckFact sendFact() throws JsonProcessingException;

  ChuckFact SendAvroFact();
}
