package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
  private int id;
  private String name;
  private String email;
  private String phone;
  private String address;
}
