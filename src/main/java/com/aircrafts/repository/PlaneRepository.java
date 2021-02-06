package com.aircrafts.repository;

import com.aircrafts.model.Plane;
import com.aircrafts.model.dto.PlaneDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
  @Query(value = "SELECT DISTINCT p.*, m.first_name, m.last_name, i.id FROM inspection i INNER JOIN plane p "
      + "on i.plane_id = p.id INNER JOIN mechanic m on i.mechanic_id = m.id", nativeQuery = true)
  List<Plane> findAllWithInspectionMechanics();

  @Query("SELECT new com.aircrafts.model.dto.PlaneDto(p.id, (SELECT group_concat(DISTINCT  m.firstName,' ', m.lastName) FROM  mechanic m JOIN Inspection i on i.plane = p AND m = i.mechanic) "
      + "            FROM  plane p")
  List<PlaneDto> findAllPlaneDTO();

}