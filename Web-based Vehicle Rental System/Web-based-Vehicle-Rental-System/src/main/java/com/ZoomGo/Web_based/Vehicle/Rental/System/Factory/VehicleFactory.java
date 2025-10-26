package com.ZoomGo.Web_based.Vehicle.Rental.System.Factory;

import com.ZoomGo.Web_based.Vehicle.Rental.System.Model.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String name, double pricePerDay, boolean available) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setType(type);
        vehicle.setPricePerDay(pricePerDay);
        vehicle.setAvailable(available);

        // Here you could customize creation based on type
        switch (type.toLowerCase()) {
            case "car":
                System.out.println("Creating a Car object");
                break;
            case "bike":
                System.out.println("Creating a Bike object");
                break;
            case "van":
                System.out.println("Creating a Van object");
                break;
            case "truck":
                System.out.println("Creating a Truck object");
                break;
            default:
                System.out.println("Creating a Generic Vehicle object");
                break;
        }
        return vehicle;
    }
}
