package com.aircrafts.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String flightCode;

  private String company;

  private String aircraftCode;

  private LocalDateTime departureDate;

  private LocalTime duration;

  private Integer crewNumber;

  @ManyToOne
  private Plane plane;

  @ManyToOne
  private Airport destination;

  @ManyToOne
  private Airport origin;

}
