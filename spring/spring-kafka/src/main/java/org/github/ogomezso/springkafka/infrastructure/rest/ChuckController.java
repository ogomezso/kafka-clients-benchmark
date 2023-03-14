package org.github.ogomezso.springkafka.infrastructure.rest;

import org.github.ogomezso.springkafka.infrastructure.kafka.ChuckAdapter;
import org.github.ogomezso.springkafka.infrastructure.rest.model.ChuckFactResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChuckController {

  private final ChuckAdapter chuckAdapter;
  private final FactResponseMapper mapper;

  @PostMapping("/chuck-says")
  public ChuckFactResponse sendFact() throws JsonProcessingException {
      return mapper.toResponse(chuckAdapter.sendFact());

  }

  @PostMapping("/chuck-says/avro")
  public ChuckFactResponse sendAvroFact() {
    return mapper.toResponse(chuckAdapter.SendAvroFact());
  }
}