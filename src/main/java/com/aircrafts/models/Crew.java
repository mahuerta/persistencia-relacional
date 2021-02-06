package com.aircrafts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Crew extends Employee {

  //Tipo Enum con los difetrentesd puestos
  private String charge;

  private String companyName;

}
