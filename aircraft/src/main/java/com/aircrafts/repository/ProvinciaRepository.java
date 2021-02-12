package com.aircrafts.repository;

import com.aircrafts.model.Provincia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

}
