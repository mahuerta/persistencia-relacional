package com.aircrafts.repository;

import com.aircrafts.model.Flight;
import com.aircrafts.model.Plane;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

  @Query(value = "SELECT f.* FROM flight f "
      + "INNER JOIN airport a on f.destination_id = a.id AND a.city = :city "
      + "AND DATE_ADD(f.departure_date, INTERVAL duration HOUR) >= :arrivalDate "
      + "AND DATE_ADD(f.departure_date, INTERVAL duration HOUR) < DATE_ADD(:arrivalDate, INTERVAL duration DAY) "
      + "ORDER BY DATE_ADD(f.departure_date, INTERVAL duration HOUR) DESC ", nativeQuery = true)
  List<Flight> findAllFlightsByCityAndArrivalDate(@Param("city") String city, @Param("arrivalDate") Date arrivalDate);


}