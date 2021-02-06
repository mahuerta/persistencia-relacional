package com.aircrafts.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewFlightId implements Serializable {

  private Long crewId;
  private Long flightId;

}
