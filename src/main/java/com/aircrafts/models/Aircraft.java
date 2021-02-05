package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aircraft {

  @Id
  @GeneratedValue
  private Long id;

  private String registration;

  private String manufacturer;

  private String model;

  private Integer flightHours;
}
