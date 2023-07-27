package org.github.ogomezso.javaconsumer.infrastructure.kafka;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.CLIENT_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.RETRY_BACKOFF_MS_CONFIG;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.github.ogomezso.javaconsumer.config.AppConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KafkaConfig {

  public static final String DESERIALIZATION_STRING_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";

  static KafkaConsumer<String, String> createKafkaConsumer(AppConfig appConfig) {

    Properties props = new Properties();
    props.put(BOOTSTRAP_SERVERS_CONFIG, appConfig.getBootstrapServers());
    props.put(CLIENT_ID_CONFIG, appConfig.getChuckClientId());
    props.put(GROUP_ID_CONFIG, appConfig.getChuckGroupId());
    props.put(MAX_POLL_INTERVAL_MS_CONFIG, 1000);
    props.put(KEY_DESERIALIZER_CLASS_CONFIG, DESERIALIZATION_STRING_DESERIALIZER);
    props.put(VALUE_DESERIALIZER_CLASS_CONFIG, DESERIALIZATION_STRING_DESERIALIZER);
    props.put(RECONNECT_BACKOFF_MS_CONFIG, appConfig.getReconnectBackoffMs());
    props.put(RECONNECT_BACKOFF_MAX_MS_CONFIG, appConfig.getReconnectBackoffMaxMs());
    props.put(RETRY_BACKOFF_MS_CONFIG, appConfig.getRetryBackOffMs());

    final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
    return consumer;
  }

}
