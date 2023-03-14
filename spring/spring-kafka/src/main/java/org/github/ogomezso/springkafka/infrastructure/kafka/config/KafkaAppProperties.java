package org.github.ogomezso.springkafka.infrastructure.kafka.config;

import lombok.Data;

@Data
public class KafkaAppProperties {

   private String  chuckClientId; 
   private String  chuckTopic;
   private String  chuckAvroClientId;
   private String  chuckAvroTopic;  
}
