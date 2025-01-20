package case_study.services;

import case_study.models.*;
import case_study.utils.FileHandler;

import java.util.*;

public class VehicleService {
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private final Set<String> licensePlates = new HashSet<>();

    public void addVehicle(Vehicle vehicle, String fileName) {
        if (isDuplicate(vehicle.getLicensePlate())) {
            throw new IllegalArgumentException("Phương tiện với biển kiểm soát này đã tồn tại!");
        }
        vehicleList.add(vehicle);
        licensePlates.add(vehicle.getLicensePlate());
        FileHandler.writeFile(fileName, vehicle.toString());
    }

    public List<String> getAllVehicles(String fileName) {
        List<String> vehicles = FileHandler.readFile(fileName);
        if (vehicles.isEmpty()) {
            return new ArrayList<>();
        }
        return vehicles;
    }

    public boolean deleteVehicle(String licensePlate, String fileName) {
        List<String> vehicles = FileHandler.readFile(fileName);
        boolean found = false;

        Iterator<String> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.startsWith(licensePlate)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            FileHandler.overwriteFile(fileName, vehicles);
            licensePlates.remove(licensePlate);
            Iterator<Vehicle> vehicleIterator = vehicleList.iterator();
            while (vehicleIterator.hasNext()) {
                Vehicle vehicle = vehicleIterator.next();
                if (vehicle.getLicensePlate().equals(licensePlate)) {
                    vehicleIterator.remove();
                    break;
                }
            }
        }
        return found;
    }

    private boolean isDuplicate(String licensePlate) {
        return licensePlates.contains(licensePlate);
    }
}
