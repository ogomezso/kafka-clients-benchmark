package org.github.ogomezso.springkafka.infrastructure.kafka.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfigProperties {
    private Map<String,String> serverProperties;
    private KafkaAppProperties appProperties;
}
