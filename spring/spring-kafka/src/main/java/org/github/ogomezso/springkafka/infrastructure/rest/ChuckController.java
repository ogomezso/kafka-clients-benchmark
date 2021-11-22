package org.github.ogomezso.springkafka.infrastructure.rest;

import java.sql.Timestamp;
import java.time.Instant;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.github.ogomezso.springkafka.infrastructure.kafka.ChuckAdapter;
import org.github.ogomezso.springkafka.infrastructure.rest.model.ChuckFactResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChuckController {

  private final ChuckAdapter chuckAdapter;
  private final FactResponseMapper mapper;

  @PostMapping("/chuck-says")
  ResponseEntity<ChuckFactResponse> sendFact() {
    try {
      ChuckFactResponse response = mapper.toResponse(chuckAdapter.sendFact());
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResponseEntity.badRequest().body(
          ChuckFactResponse.builder()
              .fact("Chuck Destroyed your request")
              .timestamp(Timestamp.from(Instant.now()).getTime())
              .build()
      );
    }
  }

  @PostMapping("/chuck-says/avro")
  ResponseEntity<ChuckFactResponse> sendAvroFact() {
    try {
      ChuckFactResponse response = mapper.toResponse(chuckAdapter.SendAvroFact());
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      log.error(e.getMessage());
      return ResponseEntity.badRequest().body(
          ChuckFactResponse.builder()
              .fact("Chuck Destroyed your request")
              .timestamp(Timestamp.from(Instant.now()).getTime())
              .build()
      );
    }
  }
}