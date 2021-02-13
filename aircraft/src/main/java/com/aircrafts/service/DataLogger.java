package com.aircrafts.service;

import com.aircrafts.model.Provincia;
import com.aircrafts.model.dto.ComunidadDto;
import com.aircrafts.model.dto.CrewDto;
import com.aircrafts.model.dto.PlaneMechanicDto;
import com.aircrafts.repository.CrewRepository;
import com.aircrafts.repository.PlaneRepository;
import com.aircrafts.repository.ProvinciaRepository;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataLogger implements CommandLineRunner {

  private final ProvinciaRepository provinciaRepository;
  private final PlaneRepository planeRepository;
  private final CrewRepository crewRepository;

  public DataLogger (ProvinciaRepository provinciaRepository, PlaneRepository planeRepository,
      CrewRepository crewRepository) {
    this.provinciaRepository = provinciaRepository;
    this.planeRepository = planeRepository;
    this.crewRepository = crewRepository;
  }

  @Override
  public void run(String... args) {
    System.out.println("EJECUCIÓN DE CONSULTAS");
    this.queryExecutor();
    this.queryMongoExecutor();
  }

  private void queryExecutor() {
    System.out.println("APARTADO 2 JSON");

    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 1: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de "
        + "sus revisiones.");
    System.out.println("-------------------------------");

    for (PlaneMechanicDto planeMechanicDto: this.planeRepository.findAllWithInspectionMechanicsJSON().stream().map(pmi -> new PlaneMechanicDto(pmi.getId(), pmi.getFirstName(),
        pmi.getLastName())).collect(Collectors.toList())) {
      System.out.println(planeMechanicDto);
    }

    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 2: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de "
        + "vuelos y la suma de horas de estos.");
    System.out.println("-------------------------------");
    for (CrewDto crewDto: this.crewRepository.findCrewFlightDetailsJSON().stream().map
        (c -> new CrewDto(c.getFirstName(),
        c.getLastName(), c.getFlightsNumber(), c.getSumFlightDuration())).collect(Collectors.toList())) {
      System.out.println(crewDto);
    }
    System.out.println();
  }

  private void queryMongoExecutor() {
    System.out.println("APARTADO 3 MONGO");

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
