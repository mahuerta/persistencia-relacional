package com.aircrafts.model;

import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Provincia {

  @Id
  private String nombre;
  private String ca;
  private int superficie;
  private List<Dato> datos;

  @Override
  public String toString() {
    return "Provincia{" +
        "nombre='" + nombre + '\'' +
        ", ca='" + ca + '\'' +
        ", superficie=" + superficie +
        ", datos=" + datos +
        '}';
  }
}
