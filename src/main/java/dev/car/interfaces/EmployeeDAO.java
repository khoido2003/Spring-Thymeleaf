package dev.car.interfaces;

import dev.car.models.Employee;

public interface EmployeeDAO {
  boolean signUp(Employee employee);

  Employee checkLogin(String email, String password);

  boolean existsByEmail(String email);
}
