package org.github.ogomezso.scs.infrastructure.kafka;

import org.github.ogomezso.scs.domain.ChuckFactPort;
import org.github.ogomezso.scs.domain.model.ChuckFact;
import org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class ChuckService implements ChuckAdapter {

  private final ChuckFactPort chuckFactPort;
  private final FactMapper mapper;
  private final ObjectMapper objectMapper;
  private final StreamBridge streamBridge;

  @Override
  public ChuckFact sendFact() throws JsonProcessingException {
    ChuckFact fact = chuckFactPort.buildFact();
    streamBridge.send("chuckProcessor-out-0",  objectMapper.writeValueAsString(fact));
    return fact;
  }

  @Override
  public ChuckFact SendAvroFact() {
    ChuckFact fact = chuckFactPort.buildFact();
    ChuckFactMsg factMsg = mapper.toAvro(fact);
    streamBridge.send("chuckAvroProcessor-out-0",factMsg);
    return fact;
  }
}
