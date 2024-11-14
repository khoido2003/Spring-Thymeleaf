package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
  private int id;
  private String name;
  private String phone;
  private String email;
  private String identityNum;
  private String createdAt;
  private String dob;
}
