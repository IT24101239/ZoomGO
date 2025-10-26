package com.ZoomGo.Web_based.Vehicle.Rental.System.Service;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Factory.VehicleFactory;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Vehicle;
import com.ZoomGo.Web_based.Vehicle.Rental.System.Repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    // Save or update vehicle using Factory Pattern
    public void saveVehicle(Vehicle vehicle) {
        // Use the factory to create a properly initialized vehicle object
        Vehicle createdVehicle = VehicleFactory.createVehicle(
                vehicle.getType(),
                vehicle.getName(),
                vehicle.getPricePerDay(),
                vehicle.isAvailable()
        );
        createdVehicle.setId(vehicle.getId()); // retain ID if updating
        vehicleRepo.save(createdVehicle);
    }

    // Delete vehicle by ID
    public void deleteVehicle(int id) {
        vehicleRepo.deleteById(id);
    }

    // Get vehicle by ID
    public Vehicle getVehicleById(int id) {
        return vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }
}
