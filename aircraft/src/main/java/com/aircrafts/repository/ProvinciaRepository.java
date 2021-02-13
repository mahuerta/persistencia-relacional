package com.aircrafts.repository;

import com.aircrafts.model.Provincia;
import com.aircrafts.model.dto.ComunidadDto;
import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

  @Aggregation(pipeline = {
            "  {$group:"
          + "        {"
          + "          _id: '$CA',"
          + "          provincias:{$sum:1}"
          + "        }"
          + "  },"
      ,
            "  { $project: {"
          + "      _id: {$ifNull: ['$_id', 'Sin comunidad']},"
          + "      provincias: 1"
          + "    }"
          + "  }"
      })
  List<ComunidadDto> groupByComunidad();
}
