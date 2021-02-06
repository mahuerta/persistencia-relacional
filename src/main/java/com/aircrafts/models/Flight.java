package com.aircrafts.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String code;

  private LocalDateTime departureDate;

  private Double duration;

  @ManyToOne
  private Company company;

  @ManyToOne
  private Plane plane;

  @ManyToOne
  private Airport destination;

  @ManyToOne
  private Airport origin;

  @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CrewFlight> crews = new ArrayList<>();

}
