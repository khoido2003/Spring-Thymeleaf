package dev.car.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.car.models.Employee;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String showHomePage(Model model, HttpSession session) {

    Employee employee = (Employee) session.getAttribute("employee");

    if (employee != null) {
      model.addAttribute("employee", employee);

      return "home";
    }

    return "redirect:/signin";
  }
}
