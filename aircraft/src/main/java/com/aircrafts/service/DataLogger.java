package com.aircrafts.service;

import com.aircrafts.model.Provincia;
import com.aircrafts.model.dto.ComunidadDto;
import com.aircrafts.repository.ProvinciaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataLogger implements CommandLineRunner {

  private final ProvinciaRepository provinciaRepository;

  public DataLogger (ProvinciaRepository provinciaRepository) {
    this.provinciaRepository = provinciaRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("EJECUCIÓN DE CONSULTAS");
    this.queryExecutor();
  }

  private void queryExecutor() {
    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 1: Listado de los datos de todas las provincias.");
    System.out.println("-------------------------------");

    for (Provincia provincia : provinciaRepository.findAll()) {
      System.out.println(provincia);
    }
    System.out.println();

    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 2: Listado mostrando, para cada comunidad autónoma, su número de provincias "
        + "(Ceuta y Melilla se consideran como parte de la comunidad autónoma “sin "
        + "comunidad”).");
    System.out.println("-------------------------------");

    for (ComunidadDto comunidadDto : provinciaRepository.groupByComunidad()) {
      System.out.println(comunidadDto);
    }


  }
}
