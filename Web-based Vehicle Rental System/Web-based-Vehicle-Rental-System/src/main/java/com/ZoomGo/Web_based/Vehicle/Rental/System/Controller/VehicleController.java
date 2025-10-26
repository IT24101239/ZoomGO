package com.ZoomGo.Web_based.Vehicle.Rental.System.Controller;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Vehicle;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicle_dashboard";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicle/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicle/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle_form";
    }

    @GetMapping("/add")
    public String addVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle_form";
    }
}
