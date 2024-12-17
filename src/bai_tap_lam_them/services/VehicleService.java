package bai_tap_lam_them.services;

import bai_tap_lam_them.models.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleService implements IVehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleService() {
        vehicles.add(new Car("30A-12345", "Toyota", 2020, "Nguyễn Văn A", 5, "Sedan"));
        vehicles.add(new Truck("29B-54321", "Hino", 2018, "Trần Thị B", 3.5));
        vehicles.add(new Motorbike("59C1-67890", "Yamaha", 2021, "Lê Văn C", 150));
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public boolean deleteVehicle(String licensePlate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle searchVehicle(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }
}
