package com.aircrafts.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ComunidadDto {

  @Field("_id")
  private String nombre;

  @Field("provincias")
  private Long provincias;
}
