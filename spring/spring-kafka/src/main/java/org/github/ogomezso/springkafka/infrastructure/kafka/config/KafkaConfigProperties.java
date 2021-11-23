package org.github.ogomezso.springkafka.infrastructure.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfigProperties {
  private String bootstrapServers;
  private String chuckClientId;
  private String chuckTopic;
  private String chuckAvroClientId;
  private String chuckAvroTopic;
  private String schemaRegistryUrl;
}
