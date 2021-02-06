package com.aircrafts.repository;

import com.aircrafts.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

interface AirportRepository extends JpaRepository<Airport, String> {

}