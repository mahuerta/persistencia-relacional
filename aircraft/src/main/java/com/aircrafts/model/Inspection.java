package com.aircrafts.model;

import com.aircrafts.model.enums.RevisionType;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Inspection {

  @Id
  @GeneratedValue
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date initialDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date finalDate;

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

  @Override
  public String toString() {
    return "Inspection{" +
        "id=" + id +
        ", initialDate=" + initialDate +
        ", finalDate=" + finalDate +
        ", duration=" + duration +
        ", description='" + description + '\'' +
        ", revisionType=" + revisionType +
        ", mechanic=" + mechanic +
        '}';
  }
}
