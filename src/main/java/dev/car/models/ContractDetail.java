package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
  private int id;
  private float overKmFee;
  private float overNightFee;
  private float holidayFee;
  private float overHourFee;
  private String status;

}
