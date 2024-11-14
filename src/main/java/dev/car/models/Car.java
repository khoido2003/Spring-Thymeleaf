package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all arguments
public class Car {
  private int id;
  private int dailyRate;
  private String status;
  private float rentalPricePerDay;
  private float maxHourRent;
  private String license;
  private String modelName;
}
