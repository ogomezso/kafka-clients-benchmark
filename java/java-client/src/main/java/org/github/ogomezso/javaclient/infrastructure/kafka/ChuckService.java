package org.github.ogomezso.javaclient.infrastructure.kafka;

import org.github.ogomezso.javaclient.config.AppConfig;
import org.github.ogomezso.javaclient.domain.ChuckFactPort;
import org.github.ogomezso.javaclient.domain.ChuckFactService;
import org.github.ogomezso.javaclient.domain.model.ChuckFact;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChuckService implements ChuckAdapter {

  private final ChuckFactPort chuckFactPort = new ChuckFactService();
  private final AppConfig appConfig;
  private final ChuckProducer producer;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public ChuckService(AppConfig appConfig) {
    this.appConfig = appConfig;
    this.producer = new ChuckProducer(appConfig);
  }

  @Override
  public ChuckFact sendFact() throws JsonProcessingException {
    ChuckFact fact = chuckFactPort.buildFact();
    String message = objectMapper.writeValueAsString(fact);
    producer.produceJsonMessage(message);
    return fact;
  }

  @Override
  public ChuckFact SendAvroFact() {
    ChuckFact fact = chuckFactPort.buildFact();
    return fact;
  }
}
