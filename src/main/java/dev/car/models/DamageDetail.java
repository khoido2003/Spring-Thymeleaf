package dev.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageDetail {
  private int id;
  private String createdAt;
  private int isFixed;
  private String damageDescription;

}
