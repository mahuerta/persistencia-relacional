package com.aircrafts.repository;

import com.aircrafts.model.Plane;
import com.aircrafts.model.dto.PlaneMechanicInterface;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
  @Query(value = "SELECT DISTINCT p.* FROM inspection i INNER JOIN plane p "
      + "on i.plane_id = p.id INNER JOIN mechanic m on i.mechanic_id = m.id", nativeQuery = true)
  List<Plane> findAllWithInspectionMechanics();


  @Query(value = "SELECT p.id, m.first_name as firstName, m.last_name as lastName FROM plane p JOIN mechanic m"
      + "  ON JSON_CONTAINS(p.inspections_json -> '$[*].mechanic_id', CAST(m.id AS JSON))"
      + "  ORDER BY p.id", nativeQuery = true)
  List<PlaneMechanicInterface> findAllWithInspectionMechanicsJSON();
}