package com.aircrafts.models;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class CrewFlightId implements Serializable {

  private Long crewId;
  private Long flightId;
}
