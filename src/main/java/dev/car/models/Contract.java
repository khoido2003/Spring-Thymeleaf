package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
  private int id;
  private String contractName;
  private String startDate;
  private String endDate;
  private String createdAt;

}
