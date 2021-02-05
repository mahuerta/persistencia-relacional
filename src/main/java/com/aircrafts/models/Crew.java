package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Crew {

  @Id
  @GeneratedValue
  private Long id;

  private String employeeCode;

  private String firstName;

  private String lastName;

  //Tipo Enum con los difetrentesd puestos
  private String charge;

  private String companyName;

}
