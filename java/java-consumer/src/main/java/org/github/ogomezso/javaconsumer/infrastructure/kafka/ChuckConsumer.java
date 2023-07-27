package org.github.ogomezso.javaconsumer.infrastructure.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

import javax.management.RuntimeErrorException;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.github.ogomezso.javaconsumer.config.AppConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChuckConsumer implements Runnable {

  private final KafkaConsumer<String, String> plainConsumer;
  private final AppConfig appConfig;
  private final CountDownLatch shutdownLatch;

  public ChuckConsumer(AppConfig appConfig) {
    this.plainConsumer = KafkaConfig.createKafkaConsumer(appConfig);
    this.appConfig = appConfig;
    this.shutdownLatch = new CountDownLatch(1);
  }

  public void pollMessage() throws Exception {

    run();

  }

  @Override
  public void run() {

    try {
      plainConsumer.subscribe(Collections.singletonList(appConfig.getChuckTopic()));

      while (true) {
        try {
          final ConsumerRecords<String, String> consumerRecords = plainConsumer.poll(Duration.ofMillis(500));
          consumerRecords.forEach(record -> {
            System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                record.key(), record.value(),
                record.partition(), record.offset());
          });
        } catch (Exception e) {
          log.error("error en poll", e);
          throw new RuntimeException();
        }

      }
    } catch (WakeupException e) {
      log.error("wakeup", e);
    } catch (Exception e) {
      log.error("Unexpected error", e);
    } finally {
      plainConsumer.close();
      shutdownLatch.countDown();
    }
  }

  public void shutdown() throws InterruptedException {
    plainConsumer.wakeup();
    shutdownLatch.await();
  }

}
