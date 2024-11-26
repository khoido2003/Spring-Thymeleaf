package dev.car.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all arguments
public class CarDetailDTO {
  private int id;
  private double dailyRate;
  private String status;
  private double rentalPricePerDay;
  private float maxHourRent;
  private String license;
  private String modelName;

  // Additional fields for CarModel
  private String year;
  private String fuelType;
  private String color;
  private int seatNum;
  private String gearBoxType;

  // Manufacturer details
  private String manufacturerName;
  private String manufacturerEmail;
  private String manufacturerPhone;
  private String manufacturerAddress;
}
