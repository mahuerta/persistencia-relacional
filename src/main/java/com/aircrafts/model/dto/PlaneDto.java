package com.aircrafts.model.dto;

import com.aircrafts.model.Mechanic;
import com.mysql.cj.xdevapi.JsonArray;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import netscape.javascript.JSObject;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class PlaneDto {

  @Id
  private BigInteger id;

  private String mechanics;

}
