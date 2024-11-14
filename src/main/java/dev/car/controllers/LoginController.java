package dev.car.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.car.dao.EmployeeDAO;
import dev.car.models.Employee;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

  @Autowired
  private EmployeeDAO employeeDAO;

  @GetMapping("/signin")
  public String showSignInForm(Model model) {
    model.addAttribute("employee", new Employee());

    return "signin";
  }

  @PostMapping("/signin")
  public String signIn(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {

    if (session.getAttribute("employee") != null) {
      // Redirect to home if already logged in
      return "redirect:/home";
    }

    Employee employee = this.employeeDAO.checkLogin(email, password);
    session.setAttribute("employee", employee);

    if (employee != null) {
      model.addAttribute("employee", employee);

      return "redirect:/home";
    } else {
      model.addAttribute("error", "Invalid email or password");
      return "signin";
    }
  }
}
