package org.github.ogomezso.springkafka.infrastructure.rest;

import org.github.ogomezso.springkafka.infrastructure.kafka.ChuckAdapter;
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

  @PostMapping("/chuck-says")
  ResponseEntity<String> sendFact() {
    try {
      return ResponseEntity.ok(chuckAdapter.sendFact());
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return ResponseEntity.noContent().build();
  }
}