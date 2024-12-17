package bai_tap_lam_them.services;

import bai_tap_lam_them.models.Vehicle;
import java.util.List;

public interface IVehicleService {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    boolean deleteVehicle(String licensePlate);
    Vehicle searchVehicle(String licensePlate);
}
