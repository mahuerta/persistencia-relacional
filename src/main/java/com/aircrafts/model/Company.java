package com.aircrafts.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Company {

  @Id
  @GeneratedValue
  private Long id;

  String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
  List<Crew> crews;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
  List<Mechanic> mechanics;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
  List<Flight> flights;

}
