ALTER TABLE plane
    ADD COLUMN inspections_json JSON;
ALTER TABLE flight
    ADD COLUMN crew_ids JSON;

