package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airport {

  @Id
  @GeneratedValue
  private Long id;

  private String codeIATA;

  private String name;

  private String city;

  private Integer country;

}
