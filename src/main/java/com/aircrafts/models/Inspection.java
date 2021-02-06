package com.aircrafts.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inspection {

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

  @ManyToOne
  private Plane plane;

  @ManyToOne
  private Airport airport;
}
