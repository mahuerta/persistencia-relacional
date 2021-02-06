package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mechanic extends Employee {

  private String companyName;

  private Integer incorporationYear;

  private String training;
}
