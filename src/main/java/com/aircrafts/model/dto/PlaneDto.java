package com.aircrafts.model.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaneDto {

  @Id
  private Long id;

  private List<MechanicDto> mechanicDto = new ArrayList<>();

  public PlaneDto(Long id, String firstName, String lastName) {
    this.id = id;
    this.mechanicDto.add(new MechanicDto(firstName,lastName));
  }
}
