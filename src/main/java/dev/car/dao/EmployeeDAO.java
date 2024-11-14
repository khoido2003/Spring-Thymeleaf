package dev.car.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.car.models.Employee;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class EmployeeDAO implements dev.car.interfaces.EmployeeDAO {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public EmployeeDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // RowMapper to map SQL results to Employee object
  private RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) {
      try {
        Employee employee = new Employee();
        employee.setName(rs.getString("name"));
        employee.setId(rs.getInt("id"));
        employee.setEmail(rs.getString("email"));
        employee.setPassword(rs.getString("password"));
        employee.setRole(rs.getString("role"));
        employee.setDob(rs.getString("dob"));
        employee.setPhoneNum(rs.getString("phoneNum"));
        employee.setAddress(rs.getString("address"));
        employee.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());

        return employee;
      } catch (Exception err) {
        err.printStackTrace();
        return null;
      }
    }
  };

  @Override
  public Employee checkLogin(String email, String password) {
    String sql = "SELECT * FROM tblemployee WHERE email = ? AND password = ?";
    try {
      List<Employee> employees = jdbcTemplate.query(sql, employeeRowMapper, new Object[] { email, password });

      return employees.isEmpty() ? null : employees.get(0);
    } catch (Exception err) {
      err.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean signUp(Employee employee) {
    if (existsByEmail(employee.getEmail())) {
      return false; // Email already exists
    }
    String sql = "INSERT INTO tblemployee (email, password, role, dob, phoneNum, address) VALUES (?, ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql,
        employee.getEmail(),
        employee.getPassword(),
        employee.getRole(),
        employee.getDob(),
        employee.getPhoneNum(),
        employee.getAddress()) > 0;
  }

  @SuppressWarnings("deprecation")
  @Override
  public boolean existsByEmail(String email) {
    String sql = "SELECT * FROM tblemployee WHERE email = ? AND password = ?";

    List<Integer> counts = jdbcTemplate.query(sql, new Object[] { email }, (rs, rowNum) -> rs.getInt(1));

    return !counts.isEmpty() && counts.get(0) > 0;
  }

}
