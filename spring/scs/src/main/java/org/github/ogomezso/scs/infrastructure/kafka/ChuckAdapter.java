package org.github.ogomezso.scs.infrastructure.kafka;


import org.github.ogomezso.scs.domain.model.ChuckFact;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ChuckAdapter {

  ChuckFact sendFact() throws JsonProcessingException;
  ChuckFact SendAvroFact();
}
