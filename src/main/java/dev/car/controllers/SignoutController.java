package dev.car.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignoutController {

  @GetMapping("/signout")
  public String signOut(HttpSession session) {
    session.invalidate();
    return "redirect:/signin";
  }
}
