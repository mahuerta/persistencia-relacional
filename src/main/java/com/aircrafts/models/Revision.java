package com.aircrafts.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Revision {

  @Id
  @GeneratedValue
  private Long id;

  private String aircraftChecked;

  private LocalDate initialDate;

  private LocalDate finalDate;

  private Integer duration;

  private String mechanic;

  private String typeOfRevision;

  private String worksDone;

  private String airport;

}
