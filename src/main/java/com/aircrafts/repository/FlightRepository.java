package com.aircrafts.repository;

import com.aircrafts.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

interface FlightRepository extends JpaRepository<Flight, String> {

}