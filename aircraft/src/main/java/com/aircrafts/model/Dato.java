package com.aircrafts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Dato {

  private String anyo;
  private String valor;

  @Override
  public String toString() {
    return "Dato{" +
        "anyo='" + anyo + '\'' +
        ", valor='" + valor + '\'' +
        '}';
  }
}
