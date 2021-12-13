package org.github.ogomezso.javaclient.domain.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ChuckFact {
  String id;
  Long timestamp;
  String fact;
}
