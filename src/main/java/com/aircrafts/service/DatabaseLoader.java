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
import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoader implements CommandLineRunner {

  private AirportRepository airportRepository;
  private CrewRepository crewRepository;
  private FlightRepository flightRepository;
  private MechanicRepository mechanicRepository;
  private PlaneRepository planeRepository;
  private CompanyRepository companyRepository;
  private InspectionRepository inspectionRepository;

  public DatabaseLoader(AirportRepository airportRepository,
      CrewRepository crewRepository, FlightRepository flightRepository,
  MechanicRepository mechanicRepository, PlaneRepository planeRepository,
      CompanyRepository companyRepository, InspectionRepository inspectionRepository) {
    this.airportRepository = airportRepository;
    this.crewRepository = crewRepository;
    this.flightRepository = flightRepository;
    this.mechanicRepository = mechanicRepository;
    this.planeRepository = planeRepository;
    this.companyRepository = companyRepository;
    this.inspectionRepository = inspectionRepository;
  }

  @Override
  public void run(String... args) {
    this.dataInitializer();

  }

  private void dataInitializer() {

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

    Flight flight1 = Flight.builder()
        .code("BA24001")
        .departureDate(LocalDate.now().minusDays(365))
        .duration(12.45)
        .company(company1)
        .plane(plane1)
        .origin(airport1)
        .destination(airport2)
        .build();

    Flight flight2 = Flight.builder()
        .code("BA24002")
        .departureDate(LocalDate.now().minusDays(10))
        .duration(2.15)
        .company(company2)
        .plane(plane2)
        .origin(airport3)
        .destination(airport2)
        .build();

    Flight flight3 = Flight.builder()
        .code("BA24003")
        .departureDate(LocalDate.now().minusDays(50))
        .duration(2.15)
        .company(company3)
        .plane(plane3)
        .origin(airport2)
        .destination(airport1)
        .build();

    Flight flight4 = Flight.builder()
        .code("BA24004")
        .departureDate(LocalDate.now().minusDays(150))
        .duration(5.97)
        .company(company1)
        .plane(plane1)
        .origin(airport1)
        .destination(airport3)
        .build();

    CrewFlight crew1Flight1 = new CrewFlight(crew1, flight1);
    CrewFlight crew4Flight1 = new CrewFlight(crew4, flight1);
    CrewFlight crew5Flight1 = new CrewFlight(crew5, flight1);
    CrewFlight crew2Flight2 = new CrewFlight(crew2, flight2);
    CrewFlight crew3Flight3 = new CrewFlight(crew3, flight3);

    flight1.setCrews(Arrays.asList(crew1Flight1, crew4Flight1, crew5Flight1));
    flight2.setCrews(Arrays.asList(crew2Flight2));
    flight3.setCrews(Arrays.asList(crew3Flight3));

    flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3, flight4));

    Inspection inspection1 = Inspection.builder()
        .plane(plane1)
        .initialDate(LocalDate.now().minusDays(160))
        .finalDate(LocalDate.now().minusDays(150))
        .duration(150.20)
        .mechanic(mechanic1)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las ruedas")
        .airport(airport1)
        .build();

    Inspection inspection2 = Inspection.builder()
        .plane(plane2)
        .initialDate(LocalDate.now().minusDays(240))
        .finalDate(LocalDate.now().minusDays(230))
        .duration(20.15)
        .mechanic(mechanic2)
        .revisionType(RevisionType.REPARATION)
        .description("Reparación de las tuercas de las puertas")
        .airport(airport2)
        .build();

    Inspection inspection3 = Inspection.builder()
        .plane(plane3)
        .initialDate(LocalDate.now().minusDays(240))
        .finalDate(LocalDate.now().minusDays(230))
        .duration(5.37)
        .mechanic(mechanic3)
        .revisionType(RevisionType.PERIODIC)
        .description("Cambio de las tuercas de las puertas")
        .airport(airport3)
        .build();

    inspectionRepository.saveAll(Arrays.asList(inspection1, inspection2,
        inspection3));
  }

}