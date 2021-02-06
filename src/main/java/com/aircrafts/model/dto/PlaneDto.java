package com.aircrafts.model.dto;

import com.aircrafts.model.Mechanic;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PlaneDto {

  private Long id;
  List<MechanicDto> mechanics;

}
