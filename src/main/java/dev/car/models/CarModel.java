package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {
  private int id;
  private String year;
  private String fuelType;
  private String color;
  private int seatNum;
  private String gearBoxType;
  private String modelName;

}
