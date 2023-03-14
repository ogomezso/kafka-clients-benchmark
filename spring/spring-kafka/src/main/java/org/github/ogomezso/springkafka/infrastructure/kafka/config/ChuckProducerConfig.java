package org.github.ogomezso.springkafka.infrastructure.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ChuckProducerConfig {

  private final KafkaConfigProperties configProperties;

  @Bean("chuckConfig")
  public Map<String, Object> chuckConfig() {

    Map<String,Object> props = new HashMap<>(configProperties.getServerProperties());
    props.put(ProducerConfig.CLIENT_ID_CONFIG, configProperties.getAppProperties().getChuckClientId());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    return props;
  }

  @Bean(name = "chuckFactory")
  public ProducerFactory<String, String> chuckFactory() {
    return new DefaultKafkaProducerFactory<>(chuckConfig());
  }

  @Bean(name = "chuckTemplate")
  public KafkaTemplate<String, String> chuckTemplate() {
    return new KafkaTemplate<>(chuckFactory());
  }
}
