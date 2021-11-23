package org.github.ogomezso.scs.infrastructure.kafka;

import java.util.function.Function;

import org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChuckAvroProcessor implements Function<ChuckFactMsg, ChuckFactMsg> {


  @Override
  public ChuckFactMsg apply(ChuckFactMsg fact) {
    return fact;
  }
}
