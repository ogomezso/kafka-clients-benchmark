package org.github.ogomezso.scs.infrastructure.kafka;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChuckProcessor implements Function<String, String> {


  @Override
  public String apply(String fact) {
    return fact;
  }
}
