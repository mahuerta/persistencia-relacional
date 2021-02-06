package com.aircrafts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Flight {

  @Id
  @GeneratedValue
  private Long id;

  private String code;

  @Temporal(TemporalType.TIMESTAMP)
  private Date departureDate;

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
