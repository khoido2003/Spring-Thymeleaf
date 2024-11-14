package dev.car.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dev.car.dtos.CarDetailDTO;
import dev.car.models.Car;

@Repository
public class CarDAO implements dev.car.interfaces.CarDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // RowMapper for mapping query results to Car objects
  private static final RowMapper<CarDetailDTO> CAR_ROW_MAPPER = (rs, rowNum) -> {
    CarDetailDTO car = new CarDetailDTO();
    car.setId(rs.getInt("id"));
    car.setDailyRate(rs.getInt("dailyRate"));
    car.setStatus(rs.getString("status"));
    car.setRentalPricePerDay(rs.getFloat("rentalPricePerDay"));
    car.setMaxHourRent(rs.getFloat("maxHourRent"));
    car.setLicense(rs.getString("license"));
    car.setModelName(rs.getString("modelName"));
    car.setYear(rs.getString("year"));
    car.setFuelType(rs.getString("fuelType"));
    car.setColor(rs.getString("color"));
    car.setSeatNum(rs.getInt("seatNum"));
    car.setGearBoxType(rs.getString("gearBoxType"));

    // Manufacturer details
    car.setManufacturerName(rs.getString("manufacturerName"));
    car.setManufacturerEmail(rs.getString("manufacturerEmail"));
    car.setManufacturerPhone(rs.getString("manufacturerPhone"));
    car.setManufacturerAddress(rs.getString("manufacturerAddress"));

    return car;
  };

  // Method to find cars by model name
  public List<CarDetailDTO> searchCar(String modelName) {
    String sql = "SELECT c.id, c.dailyRate, c.status, c.rentalPricePerDay, " +
        "c.maxHourRent, c.license, cm.modelName, cm.year, cm.fuelType, cm.color, cm.seatNum, " +
        "cm.gearBoxType, m.name AS manufacturerName, m.email AS manufacturerEmail, " +
        "m.phone AS manufacturerPhone, m.address AS manufacturerAddress " +
        "FROM tblCar c " +
        "JOIN tblCarModel cm ON c.tblCarModelid = cm.id " +
        "JOIN tblManufacturer m ON cm.tblManufacturerid = m.id " +
        "WHERE cm.modelName LIKE ?";

    return jdbcTemplate.query(sql, CAR_ROW_MAPPER, "%" + modelName + "%");
  }

  public int updateCar(CarDetailDTO carDetail) {
    try {
      String sql = "UPDATE tblCar c " +
          "JOIN tblCarModel cm ON c.tblCarModelid = cm.id " +
          "JOIN tblManufacturer m ON cm.tblManufacturerid = m.id " +
          "SET c.dailyRate = ?, c.status = ?, c.rentalPricePerDay = ?, " +
          "c.maxHourRent = ?, c.license = ?, cm.modelName = ?, cm.year = ?, " +
          "cm.fuelType = ?, cm.color = ?, cm.seatNum = ?, cm.gearBoxType = ?, " +
          "m.name = ?, m.email = ?, m.phone = ?, m.address = ? " +
          "WHERE c.id = ?";

      int result = jdbcTemplate.update(sql,
          carDetail.getDailyRate(),
          carDetail.getStatus(),
          carDetail.getRentalPricePerDay(),
          carDetail.getMaxHourRent(),
          carDetail.getLicense(),
          carDetail.getModelName(),
          carDetail.getYear(),
          carDetail.getFuelType(),
          carDetail.getColor(),
          carDetail.getSeatNum(),
          carDetail.getGearBoxType(),
          carDetail.getManufacturerName(),
          carDetail.getManufacturerEmail(),
          carDetail.getManufacturerPhone(),
          carDetail.getManufacturerAddress(),
          carDetail.getId());

      System.out.println(result);

      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

}
