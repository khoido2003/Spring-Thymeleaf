package dev.car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.car.dao.CarDAO;
import dev.car.dtos.CarDetailDTO;
import dev.car.models.Car;
import jakarta.servlet.http.HttpSession;

@Controller
public class SearchCarController {

  @Autowired
  private CarDAO carDAO;

  @GetMapping("/searchCar")
  public String showSearchCar(HttpSession session, Model model) {
    return "searchCar";
  }

  @PostMapping("/searchCar")
  public String searchCar(@RequestParam String carName, HttpSession session, Model model) {

    List<CarDetailDTO> listCar = carDAO.searchCar(carName);
    model.addAttribute("carList", listCar);

    return "searchCar";
  }

}
