package com.aircrafts.service;

import com.aircrafts.model.Airport;
import com.aircrafts.model.Company;
import com.aircrafts.model.Crew;
import com.aircrafts.model.CrewFlight;
import com.aircrafts.model.Flight;
import com.aircrafts.model.Inspection;
import com.aircrafts.model.Mechanic;
import com.aircrafts.model.Plane;
import com.aircrafts.model.enums.Position;
import com.aircrafts.model.enums.RevisionType;
import com.aircrafts.model.enums.Training;
import com.aircrafts.repository.AirportRepository;
import com.aircrafts.repository.CompanyRepository;
import com.aircrafts.repository.CrewRepository;
import com.aircrafts.repository.FlightRepository;
import com.aircrafts.repository.InspectionRepository;
import com.aircrafts.repository.MechanicRepository;
import com.aircrafts.repository.PlaneRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoader implements CommandLineRunner {

  private final AirportRepository airportRepository;
  private final FlightRepository flightRepository;
  private final MechanicRepository mechanicRepository;
  private final PlaneRepository planeRepository;
  private final CompanyRepository companyRepository;
  private final InspectionRepository inspectionRepository;
  private final CrewRepository crewRepository;

  public DatabaseLoader(AirportRepository airportRepository,
      FlightRepository flightRepository,
  MechanicRepository mechanicRepository, PlaneRepository planeRepository,
      CompanyRepository companyRepository, InspectionRepository inspectionRepository,
      CrewRepository crewRepository) {
    this.airportRepository = airportRepository;
    this.flightRepository = flightRepository;
    this.mechanicRepository = mechanicRepository;
    this.planeRepository = planeRepository;
    this.companyRepository = companyRepository;
    this.inspectionRepository = inspectionRepository;
    this.crewRepository = crewRepository;
  }

  @Override
  public void run(String... args) throws ParseException {
    // System.out.println("CARGA DE DATOS");
    // this.dataInitializer();

    // System.out.println("EJECUCIÓN DE CONSULTAS");
    // this.queryExecutor();
  }

  private void queryExecutor() throws ParseException {
    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 1: Para cada avión, mostrar el nombre y apellidos de los mecánicos "
        + "responsables de sus revisiones.");
    System.out.println("----------------------------------------");

    List<Plane> planes = this.planeRepository.findAllWithInspectionMechanics();
    for(Plane p: planes) {
      System.out.println("Plane: " + p.getId());
      for(Inspection i: p.getInspections()){
        Mechanic mechanic = i.getMechanic();
        System.out.println("Fullname: " + mechanic.getFirstName() + " " + mechanic.getLastName());
      }
    }

    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 2: Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado "
        + "(destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora");
    System.out.println("----------------------------------------");

    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    List<Flight> flights = this.flightRepository.findAllFlightsByCityAndArrivalDate("Madrid", format.parse("2020/11/10"));
    for(Flight f: flights){
      System.out.println("Flight: " + f.getId() + " Arrival Date: departure date ("
          + f.getDepartureDate() + ") + duration (" + f.getDuration() +" hours)");
    }
    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 3: Dado el código de empleado de un tripulante, "
        + "mostrar su nombre y apellidos y las ciudades desde las que ha despegado "
        + "junto con la fecha en que despegó. ");
    System.out.println("----------------------------------------");

    this.crewRepository.findCrewAndFlightDetailsUsingCode("COD001").forEach(System.out::println);

    System.out.println("----------------------------------------");
    System.out.println("-- CONSULTA 4: Para cada tripulante, mostrar su nombre y apellidos junto con su "
        + "número total de vuelos y la suma de horas de estos");
    System.out.println("----------------------------------------");

    this.crewRepository.findCrewFlightDetails().forEach(System.out::println);

  }

  private void dataInitializer() throws ParseException {

    Airport airport1 = Airport.builder()
        .codeIATA("IA1")
        .name("Barajas")
        .city("Madrid")
        .country("España")
        .build();

    Airport airport2 = Airport.builder()
        .codeIATA("IA2")
        .name("Villanubla")
        .city("Valladolid")
        .country("España")
        .build();

    Airport airport3 = Airport.builder()
        .codeIATA("IA3")
        .name("Gatwick")
        .city("Londres")
        .country("Inglaterra")
        .build();

    Plane plane1 = Plane.builder()
        .registration("N1000A1")
        .manufacturer("Boeing")
        .model("747")
        .flightHours(250.24)
        .build();

    Plane plane2 = Plane.builder()
        .registration("N1000A2")
        .manufacturer("Airbus")
        .model("350")
        .flightHours(12.87)
        .build();

    Plane plane3 = Plane.builder()
        .registration("N1000A3")
        .manufacturer("Boeing")
        .model("777")
        .flightHours(9530.61)
        .build();

    Company company1 = Company.builder()
        .name("Iberia")
        .build();

    Company company2 = Company.builder()
        .name("Reparaciones Paco")
        .build();

    Company company3 = Company.builder()
        .name("American Airlines")
        .build();

    Crew crew1 = Crew.builder()
        .position(Position.CO_PILOT)
        .code("COD001")
        .firstName("Juan Carlos")
        .lastName("Blázquez")
        .company(company1)
        .build();

    Crew crew2 = Crew.builder()
        .position(Position.COMMANDER)
        .code("COD002")
        .firstName("Miguel Ángel")
        .lastName("Huerta")
        .company(company2)
        .build();

    Crew crew3 = Crew.builder()
        .position(Position.FLIGHT_ATTENDANT)
        .code("COD003")
        .firstName("Marta")
        .lastName("Sánchez")
        .company(company3)
        .build();

    Crew crew4 = Crew.builder()
        .position(Position.COMMANDER)
        .code("COD004")
        .firstName("Antonio")
        .lastName("Velasco")
        .company(company1)
        .build();

    Crew crew5 = Crew.builder()
        .position(Position.COMMANDER)
        .code("COD005")
        .firstName("José")
        .lastName("López")
        .company(company1)
        .build();

    Mechanic mechanic1 = Mechanic.builder()
        .code("MEC001")
        .firstName("Pablo")
        .lastName("Marbán")
        .incorporationYear(2017)
        .training(Training.DEGREE)
        .company(company1)
        .build();

    Mechanic mechanic2 = Mechanic.builder()
        .code("MEC002")
        .firstName("Luis")
        .lastName("Calvo")
        .incorporationYear(2015)
        .training(Training.VT)
        .company(company2)
        .build();

    Mechanic mechanic3 = Mechanic.builder()
        .code("MEC003")
        .firstName("Francisco")
        .lastName("Moreno")
        .incorporationYear(2017)
        .training(Training.SUPERIOR)
        .company(company3)
        .build();

    Mechanic mechanic4 = Mechanic.builder()
        .code("MEC004")
        .firstName("Pedro")
        .lastName("Martínez")
        .incorporationYear(2017)
        .training(Training.SUPERIOR)
        .company(company1)
        .build();

    Mechanic mechanic5 = Mechanic.builder()
        .code("MEC005")
        .firstName("Jesús")
        .lastName("Navarro")
        .incorporationYear(2017)
        .training(Training.SUPERIOR)
        .company(company1)
        .build();

    airportRepository.saveAll(Arrays.asList(airport1, airport2, airport3));
    planeRepository.saveAll(Arrays.asList(plane1, plane2, plane3));
    companyRepository.saveAll(Arrays.asList(company1, company2, company3));
    mechanicRepository.saveAll(Arrays.asList(mechanic1, mechanic2, mechanic3, mechanic4, mechanic5));

    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    Flight flight1 = Flight.builder()
        .code("BA24001")
        .departureDate(format.parse("2020/11/09 18:12:25"))
        .duration(12.45)
        .company(company1)
        .plane(plane1)
        .origin(airport3)
        .destination(airport1)
        .build();

    Flight flight2 = Flight.builder()
        .code("BA24002")
        .departureDate(format.parse("2021/01/10 10:12:25"))
        .duration(3.15)
        .company(company2)
        .plane(plane2)
        .origin(airport3)
        .destination(airport2)
        .build();

    Flight flight3 = Flight.builder()
        .code("BA24003")
        .departureDate(format.parse("2020/11/10 20:15:55"))
        .duration(1.15)
        .company(company3)
        .plane(plane3)
        .origin(airport2)
        .destination(airport1)
        .build();

    Flight flight4 = Flight.builder()
        .code("BA24004")
        .departureDate(format.parse("2020/11/10 00:12:01"))
        .duration(5.97)
        .company(company1)
        .plane(plane1)
        .origin(airport3)
        .destination(airport1)
        .build();

    Flight flight5 = Flight.builder()
        .code("BA24005")
        .departureDate(format.parse("2020/11/10 23:00:00"))
        .duration(5.97)
        .company(company1)
        .plane(plane1)
        .origin(airport3)
        .destination(airport1)
        .build();

    CrewFlight crew1Flight1 = new CrewFlight(crew1, flight1);
    CrewFlight crew4Flight1 = new CrewFlight(crew4, flight1);
    CrewFlight crew5Flight1 = new CrewFlight(crew5, flight1);
    CrewFlight crew2Flight2 = new CrewFlight(crew2, flight2);
    CrewFlight crew3Flight3 = new CrewFlight(crew3, flight3);
    CrewFlight crew1Flight3 = new CrewFlight(crew1, flight3);
    CrewFlight crew2Flight5 = new CrewFlight(crew2, flight5);

    flight1.setCrews(Arrays.asList(crew1Flight1, crew4Flight1, crew5Flight1));
    flight2.setCrews(Collections.singletonList(crew2Flight2));
    flight3.setCrews(Arrays.asList(crew3Flight3, crew1Flight3));
    flight5.setCrews(Collections.singletonList(crew2Flight5));

    flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3, flight4, flight5));

    Inspection inspection1 = Inspection.builder()
        .plane(plane1)
        .initialDate(format.parse("2021/01/01 08:00:00"))
        .finalDate(format.parse("2021/01/10 10:00:00"))
        .duration(150.20)
        .mechanic(mechanic1)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las ruedas delanteras")
        .airport(airport1)
        .build();

    Inspection inspection2 = Inspection.builder()
        .plane(plane2)
        .initialDate(format.parse("2021/01/01 08:00:00"))
        .finalDate(format.parse("2021/03/10 10:00:00"))
        .duration(20.15)
        .mechanic(mechanic2)
        .revisionType(RevisionType.REPARATION)
        .description("Reparación de las tuercas de las puertas")
        .airport(airport2)
        .build();

    Inspection inspection3 = Inspection.builder()
        .plane(plane3)
        .initialDate(format.parse("2021/01/01 08:00:00"))
        .finalDate(format.parse("2021/01/10 17:00:00"))
        .duration(5.37)
        .mechanic(mechanic3)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las tuercas de las puertas")
        .airport(airport3)
        .build();

    Inspection inspection4 = Inspection.builder()
        .plane(plane1)
        .initialDate(format.parse("2020/11/01 08:00:00"))
        .finalDate(format.parse("2021/01/10 10:00:00"))
        .duration(134.23)
        .mechanic(mechanic1)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las ruedas traseras")
        .airport(airport1)
        .build();

    Inspection inspection5 = Inspection.builder()
        .plane(plane1)
        .initialDate(format.parse("2020/10/01 08:00:00"))
        .finalDate(format.parse("2020/10/10 15:00:00"))
        .duration(5.5)
        .mechanic(mechanic2)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las persianas de las ventanillas")
        .airport(airport2)
        .build();

    inspectionRepository.saveAll(Arrays.asList(inspection1, inspection2,
        inspection3, inspection4, inspection5));
  }

}