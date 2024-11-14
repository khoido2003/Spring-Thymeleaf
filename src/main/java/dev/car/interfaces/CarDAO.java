package dev.car.interfaces;

import java.util.List;

import dev.car.dtos.CarDetailDTO;

public interface CarDAO {

  List<CarDetailDTO> searchCar(String name);
}
