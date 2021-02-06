package com.aircrafts.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
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
