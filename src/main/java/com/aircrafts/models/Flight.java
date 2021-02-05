package com.aircrafts.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String flightCode;

  private String company;

  private String aircraftCode;

  private String destinyAirport;

  private String departureAirport;

  private LocalDateTime departureDate;

  private LocalTime flightDuration;

  private Integer crewNumber;

}
