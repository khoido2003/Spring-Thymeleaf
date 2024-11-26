package dev.car.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.car.dao.CarDAO;
import dev.car.dtos.CarDetailDTO;
import jakarta.servlet.http.HttpSession;

@Controller
public class EditCarController {

  @Autowired
  public CarDAO carDAO;

  @GetMapping("/editCar")
  public String showEditCar(@RequestParam("id") int carId, Model model, HttpSession session) {

    // Retrieve the list of cars from the session
    @SuppressWarnings("unchecked")
    List<CarDetailDTO> listCar = (List<CarDetailDTO>) session.getAttribute("carList");

    // Check if the list is null
    if (listCar == null) {
      model.addAttribute("error", "No cars available.");
      return "errorPage";
    }

    // Find the car to edit
    CarDetailDTO carToEdit = listCar.stream()
        .filter(car -> car.getId() == carId)
        .findFirst()
        .orElse(null);

    if (carToEdit != null) {
      model.addAttribute("carEdit", carToEdit);
    } else {
      model.addAttribute("error", "Car not found.");
      return "errorPage";
    }
    return "editCar";
  }

  @PostMapping("/editCar")
  public String updateCar(
      @RequestParam("id") int carId,
      @RequestParam("modelName") String modelName,
      @RequestParam("manufacturerName") String manufacturerName,
      @RequestParam("manufacturerEmail") String manufacturerEmail,
      @RequestParam("manufacturerPhone") String manufacturerPhone,
      @RequestParam("manufacturerAddress") String manufacturerAddress,
      @RequestParam("year") String year,
      @RequestParam("fuelType") String fuelType,
      @RequestParam("color") String color,
      @RequestParam("seatNum") int seatNum,
      @RequestParam("gearBoxType") String gearBoxType,
      @RequestParam("dailyRate") double dailyRate,
      @RequestParam("status") String status,
      @RequestParam("rentalPricePerDay") double rentalPricePerDay,
      @RequestParam("maxHourRent") float maxHourRent,
      @RequestParam("license") String license,
      HttpSession session,
      Model model) {

    // Create the updated car object with the form data
    CarDetailDTO updatedCar = new CarDetailDTO();
    updatedCar.setId(carId);
    updatedCar.setModelName(modelName);
    updatedCar.setManufacturerName(manufacturerName);
    updatedCar.setManufacturerEmail(manufacturerEmail);
    updatedCar.setManufacturerPhone(manufacturerPhone);
    updatedCar.setManufacturerAddress(manufacturerAddress);
    updatedCar.setYear(year);
    updatedCar.setFuelType(fuelType);
    updatedCar.setColor(color);
    updatedCar.setSeatNum(seatNum);
    updatedCar.setGearBoxType(gearBoxType);
    updatedCar.setStatus(status);
    updatedCar.setMaxHourRent(maxHourRent);
    updatedCar.setLicense(license);
    updatedCar.setRentalPricePerDay(rentalPricePerDay);
    updatedCar.setDailyRate(dailyRate);

    System.out.println(updatedCar.toString());
    // Update the car in the database
    int updateSuccess = carDAO.updateCar(updatedCar);

    if (updateSuccess > 0) {
      // Retrieve the current car list from the session
      @SuppressWarnings("unchecked")
      List<CarDetailDTO> carList = (List<CarDetailDTO>) session.getAttribute("carList");

      if (carList != null) {
        // Update the car in the session list
        carList = carList.stream()
            .map(car -> car.getId() == carId ? updatedCar : car)
            .collect(Collectors.toList());

        // Set the updated list back into the session
        session.setAttribute("carList", carList);

        return "redirect:/editCar?id=" + carId + "&success=true";

      } else {

        return "redirect:/editCar?id=" + carId + "&success=false";
      }
    } else {

      return "redirect:/editCar?id=" + carId + "&success=false";
    }
  }
}
