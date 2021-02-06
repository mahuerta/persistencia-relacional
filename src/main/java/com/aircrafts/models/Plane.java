package com.aircrafts.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plane {

  /* Fetch LAZY: No carga las revisiones */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane")
  List<Inspection> inspections;
  /* Fetch LAZY: No carga los vuelos */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane")
  List<Flight> flights;
  @Id
  @GeneratedValue
  private Long id;
  private String registration;
  private String manufacturer;
  private String model;
  private Integer flightHours;
}
