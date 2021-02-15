package com.aircrafts.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewCodeDto {

  String firstName;
  String lastName;
  String country;
  Date departureDate;
}
