package org.github.ogomezso.scs.infrastructure.rest.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChuckFactResponse {

  private Long timestamp;
  private String fact;
}
