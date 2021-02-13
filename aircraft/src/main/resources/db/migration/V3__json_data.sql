UPDATE test.flight f SET f.crew_ids =
                             (SELECT JSON_ARRAYAGG(crew_id) AS crew_ids FROM crew_flight cf WHERE f.id = cf.flight_id);

UPDATE plane p SET inspections_json = (SELECT JSON_ARRAYAGG(JSON_OBJECT
    ('id', i.id,
     'descripcion', i.description,
     'duration', i.duration,
     'final_date', i.final_date,
     'initial_date', i.initial_date,
     'revision_type', i.revision_type,
     'airport_id', i.airport_id,
     'mechanic_id', i.mechanic_id,
     'plane_id', i.plane_id
    ))
FROM inspection i WHERE i.plane_id = p.id);