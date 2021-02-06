package com.aircrafts.repository;

import com.aircrafts.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

interface PlaneRepository extends JpaRepository<Plane, String> {

}