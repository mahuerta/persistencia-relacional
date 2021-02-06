package com.aircrafts.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CrewFlight {

  @EmbeddedId
  private CrewFlightId id;

  @ManyToOne
  @MapsId("crewId")
  private Crew crew;

  @ManyToOne
  @MapsId("flightId")
  private Flight flight;

  public CrewFlight(Crew crew, Flight flight) {
    this.crew = crew;
    this.flight = flight;

    this.id = new CrewFlightId(crew.getId(), flight.getId());
  }

}
