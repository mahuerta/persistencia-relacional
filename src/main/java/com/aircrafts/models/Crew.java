package com.aircrafts.models;

import com.aircrafts.models.enums.Position;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Crew extends Employee {

  @Enumerated(EnumType.STRING)
  private Position position;

  @OneToMany(mappedBy = "crew", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CrewFlight> flights = new ArrayList<>();

}
