package com.aircrafts.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Provincia {

  @Id
  private String id;

  @Field("Nombre")
  private String nombre;

  @Field("CA")
  private String ca;

  @Field("Superficie")
  private int superficie;

  @Field("Datos")
  private List<Dato> datos;

  @Override
  public String toString() {
    return "Provincia{" +
        "id='" + id + '\'' +
        ", nombre='" + nombre + '\'' +
        ", ca='" + ca + '\'' +
        ", superficie=" + superficie +
        ", datos=" + datos +
        '}';
  }

}
