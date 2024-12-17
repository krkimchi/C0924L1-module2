package bai_tap_lam_them.controller;

import bai_tap_lam_them.models.*;
import bai_tap_lam_them.services.VehicleService;

import java.util.List;

public class VehicleController {
    private VehicleService vehicleService = new VehicleService();

    public boolean addVehicle(int type, String license, String manufacturer, int year, String owner, int seats, String carType, double load, int power) {
        switch (type) {
            case 1:
                vehicleService.addVehicle(new Car(license, manufacturer, year, owner, seats, carType));
                return true;
            case 2:
                vehicleService.addVehicle(new Truck(license, manufacturer, year, owner, load));
                return true;
            case 3:
                vehicleService.addVehicle(new Motorbike(license, manufacturer, year, owner, power));
                return true;
            default:
                return false;
        }
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    public boolean deleteVehicle(String licensePlate) {
        return vehicleService.deleteVehicle(licensePlate);
    }

    public Vehicle searchVehicle(String licensePlate) {
        return vehicleService.searchVehicle(licensePlate);
    }
}
