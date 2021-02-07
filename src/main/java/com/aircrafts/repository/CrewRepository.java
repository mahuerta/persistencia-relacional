package com.aircrafts.repository;

import com.aircrafts.model.Crew;
import com.aircrafts.model.dto.CrewCodeDto;
import com.aircrafts.model.dto.CrewDto;
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

}