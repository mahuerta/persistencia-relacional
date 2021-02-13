package com.aircrafts.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Plane {

  @Id
  @GeneratedValue
  private Long id;

  private String registration;

  private String manufacturer;

  private String model;

  private Double flightHours;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane", fetch = FetchType.EAGER)
  List<Inspection> inspections;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane")
  List<Flight> flights;

  // Objeto JSON
  private String inspectionsJson;

  @Override
  public String toString() {
    return "Plane{" +
        "id=" + id +
        ", registration='" + registration + '\'' +
        ", manufacturer='" + manufacturer + '\'' +
        ", model='" + model + '\'' +
        ", flightHours=" + flightHours +
        ", inspections=" + inspections +
        '}';
  }
}
