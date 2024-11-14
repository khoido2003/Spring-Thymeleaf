package dev.car.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageCarController {

  @GetMapping("/manageCar")
  public String showManageCar(HttpSession session, Model model) {
    return "manageCar";
  }

}