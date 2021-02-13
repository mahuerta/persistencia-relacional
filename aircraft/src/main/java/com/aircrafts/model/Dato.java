package com.aircrafts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Dato {

  @Field("Anyo")
  private String anyo;

  @Field("Valor")
  private String valor;

  @Override
  public String toString() {
    return "Dato{" +
        "anyo='" + anyo + '\'' +
        ", valor='" + valor + '\'' +
        '}';
  }
}
