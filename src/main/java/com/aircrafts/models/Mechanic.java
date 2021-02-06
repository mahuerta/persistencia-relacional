package com.aircrafts.models;

import com.aircrafts.models.enums.Training;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mechanic extends Employee {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mechanic")
  List<Inspection> inspections;
  private Integer incorporationYear;
  private Training training;
}
