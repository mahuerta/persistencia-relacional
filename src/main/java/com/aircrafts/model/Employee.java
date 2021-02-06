package com.aircrafts.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String code;

  private String firstName;

  private String lastName;

  @ManyToOne
  private Company company;

}
