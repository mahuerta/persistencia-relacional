package com.aircrafts.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CrewCodeDto {
  String firstName;
  String lastName;
  String country;
  Date departureDate;
}
