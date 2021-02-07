package com.aircrafts.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewDto {
  String firstName;
  String lastName;
  Long flightsNumber;
  Double sumFlightDuration;
}
