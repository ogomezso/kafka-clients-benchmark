package org.github.ogomezso.scs.infrastructure.rest;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChuckController {

  private final StreamBridge streamBridge;
  private final Faker faker = new Faker();

  @PostMapping("/chuck-says")
  ResponseEntity<String> sendFact() {
    String fact = faker.chuckNorris().fact();
    try {
      streamBridge.send("chuckProcessor-out-0", fact);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return ResponseEntity.ok("chuckSays:" + fact);
  }

}
