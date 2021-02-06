package com.aircrafts.repository;

import com.aircrafts.models.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

interface CrewRepository extends JpaRepository<Crew, String> {

}