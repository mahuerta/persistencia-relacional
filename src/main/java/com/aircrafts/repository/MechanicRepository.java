package com.aircrafts.repository;

import com.aircrafts.models.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

interface MechanicRepository extends JpaRepository<Mechanic, String> {

}