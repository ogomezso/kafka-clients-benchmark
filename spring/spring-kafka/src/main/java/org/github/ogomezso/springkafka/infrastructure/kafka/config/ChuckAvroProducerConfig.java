package org.github.ogomezso.springkafka.infrastructure.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.github.ogomezso.springkafka.infrastructure.model.chuck.ChuckFactMsg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ChuckAvroProducerConfig {

  private static final String SCHEMA_REGISTRY_URL = "schema.registry.url";
  private final KafkaConfigProperties configProperties;

  @Bean("chuckAvroConfig")
  public Map<String, Object> chuckAvroConfig() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, configProperties.getBootstrapServers());
    props.put(ProducerConfig.CLIENT_ID_CONFIG, configProperties.getChuckAvroClientId());
    props.put(ProducerConfig.ACKS_CONFIG, "all");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
    props.put(SCHEMA_REGISTRY_URL, configProperties.getSchemaRegistryUrl());

    return props;
  }

  @Bean(name = "chuckAvroFactory")
  public ProducerFactory<String, ChuckFactMsg> chuckAvroFactory() {
    return new DefaultKafkaProducerFactory<>(chuckAvroConfig());
  }

  @Bean(name = "chuckAvroTemplate")
  public KafkaTemplate<String, ChuckFactMsg> chuckAvroTemplate() {
    return new KafkaTemplate<>(chuckAvroFactory());
  }
}
