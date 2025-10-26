package com.ZoomGo.Web_based.Vehicle.Rental.System.Repo;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> { }
