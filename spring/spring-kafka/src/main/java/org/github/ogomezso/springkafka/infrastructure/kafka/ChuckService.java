package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class ChuckService implements ChuckAdapter {

  private final Faker faker = new Faker();
  private final ChuckProducer chuckProducer;

  @Override
  public String sendFact() {
    String fact = faker.chuckNorris().fact();
    return chuckProducer.sendFact(fact);
  }
}
