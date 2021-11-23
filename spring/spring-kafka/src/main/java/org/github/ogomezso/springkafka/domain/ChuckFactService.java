package org.github.ogomezso.springkafka.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
class ChuckFactService implements ChuckFactPort {

  private final Faker faker = new Faker();

  @Override
  public ChuckFact buildFact() {
    return ChuckFact.builder()
        .id(UUID.randomUUID().toString())
        .timestamp(Timestamp.from(Instant.now()).getTime())
        .fact(faker.chuckNorris().fact())
        .build();
  }
}
