package com.aircrafts.models;

import com.aircrafts.models.enums.RevisionType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

  private Double duration;

  private String description;

  @Enumerated(EnumType.STRING)
  private RevisionType revisionType;

  @ManyToOne
  private Plane plane;

  @ManyToOne
  private Airport airport;

  @ManyToOne
  private Mechanic mechanic;

}
