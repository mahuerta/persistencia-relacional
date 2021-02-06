package com.aircrafts.repository;

import com.aircrafts.model.Plane;
import com.aircrafts.model.dto.PlaneDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {


}