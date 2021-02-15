package com.aircrafts.model;

import com.aircrafts.model.enums.Training;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Mechanic extends Employee {

  private Integer incorporationYear;

  private Training training;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mechanic")
  List<Inspection> inspections;

  @Override
  public String toString() {
    return super.toString() + "Mechanic {" +
        "incorporationYear=" + incorporationYear +
        ", training=" + training +
        '}';
  }
}
