package com.aircrafts.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Airport {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 3)
  private String codeIATA;

  private String name;

  private String city;

  private String country;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "airport")
  List<Inspection> inspections;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin")
  List<Flight> origins;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
  List<Flight> destinations;

}
