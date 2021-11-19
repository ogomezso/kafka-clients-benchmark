package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.infrastructure.kafka.config.KafkaConfigProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
class ChuckProducer {

  private final KafkaConfigProperties configProperties;

  @Qualifier("chuckTemplate")
  private final KafkaTemplate<String, String> chuckTemplate;

  ChuckProducer(
      KafkaConfigProperties configProperties,
      KafkaTemplate<String, String> chuckTemaplate) {
    this.configProperties = configProperties;
    this.chuckTemplate = chuckTemaplate;
  }

  public String sendFact(String fact) {

    ListenableFuture<SendResult<String, String>> resultFuture = chuckTemplate
        .send(configProperties.getChuckTopic(), fact);

    resultFuture.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error("Unable to Send chuck fact to kafka: {}", fact);
      }

      @Override
      public void onSuccess(SendResult<String, String> result) {
        log.info("chuck fact delivered: {}. Event Offset: {}",fact,
            result.getRecordMetadata().offset());
      }
    });

    return fact;
  }
}
