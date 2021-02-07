package com.aircrafts.model.dto;

import java.util.Date;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

  @Id
  private Long id;

//  private Date arrivalDate;

}
