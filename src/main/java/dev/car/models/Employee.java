package dev.car.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all arguments
public class Employee {
  private int id;
  private String email;
  private String password;
  private String role;
  private String dob;
  private String phoneNum;
  private LocalDateTime createdAt;
  private String address;
}
