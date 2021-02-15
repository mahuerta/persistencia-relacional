package com.aircrafts.repository;

import com.aircrafts.model.Crew;
import com.aircrafts.model.dto.CrewCodeDto;
import com.aircrafts.model.dto.CrewDto;
import com.aircrafts.model.dto.CrewInterface;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {

  @Query("SELECT new com.aircrafts.model.dto.CrewDto"
      + "(c.firstName , c.lastName, COUNT(f.id), "
      + " SUM(f.duration)) FROM CrewFlight cf"
      + " INNER JOIN Flight f on cf.flight = f "
      + " INNER JOIN Crew c on cf.crew = c "
      + " GROUP BY c.firstName, c.lastName")
  List<CrewDto> findCrewFlightDetails();

  @Query("SELECT new com.aircrafts.model.dto.CrewCodeDto"
      + "(c.firstName, c.lastName, a.city, f.departureDate) "
      + "FROM Crew c "
      + "JOIN CrewFlight cf on c = cf.crew "
      + "JOIN Flight f on f = cf.flight "
      + "JOIN Airport a on f.destination = a "
      + "WHERE c.code = :code")
  List<CrewCodeDto> findCrewAndFlightDetailsUsingCode(@Param("code") String code);

  @Query(value =
      "SELECT c.first_name as firstName, c.last_name as lastName, COUNT(f.id) as flightsNumber, SUM(f.duration) "
          + "as sumFlightDuration FROM crew c JOIN flight f ON JSON_CONTAINS(f.crew_ids, CAST(c.id AS JSON), '$') "
          + "GROUP BY c.first_name, c.last_name ORDER BY c.first_name", nativeQuery = true)
  List<CrewInterface> findCrewFlightDetailsJSON();

}