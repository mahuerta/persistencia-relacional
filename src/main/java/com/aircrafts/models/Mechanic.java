package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mechanic {

  @Id
  @GeneratedValue
  private Long id;

  private String employeeCode;

  private String firstName;

  private String lastName;

  private String companyName;

  private Integer incorporationYear;

  private String training;
}
