package dev.car.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.car.dao.EmployeeDAO;
import dev.car.models.Employee;

@Controller
@SessionAttributes
public class EmployeeController {

  @Autowired
  private EmployeeDAO employeeDAO;

  @GetMapping("/signin")
  public String showSignInForm(Model model) {
    model.addAttribute("employee", new Employee());

    return "signin";
  }

  @PostMapping("/signin")
  public String signIn(@RequestParam String email, @RequestParam String password, Model model) {
    Employee employee = this.employeeDAO.checkLogin(email, password);

    if (employee != null) {
      model.addAttribute("employee", employee);

      return "dashboard";
    } else {
      model.addAttribute("error", "Invalid email or password");
      return "signin";
    }

  }

}
