package com.aircrafts.models;

import javax.persistence.Entity;
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
