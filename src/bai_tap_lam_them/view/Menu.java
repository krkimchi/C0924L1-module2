package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.VehicleController;
import bai_tap_lam_them.models.Vehicle;
import bai_tap_lam_them.utils.InputValidator;

import java.util.List;

public class Menu {
    private VehicleController controller = new VehicleController();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ PHƯƠNG TIỆN =====");
            System.out.println("1. Thêm phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm phương tiện");
            System.out.println("5. Thoát");

            choice = InputValidator.getIntInput("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    searchVehicle();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private void addVehicle() {
        System.out.println("1. Ôtô | 2. Xe tải | 3. Xe máy");
        int type = InputValidator.getIntInput("Chọn loại phương tiện: ");
        String license = InputValidator.getStringInput("Nhập biển số: ");
        String manufacturer = InputValidator.getStringInput("Nhập hãng sản xuất: ");
        int year = InputValidator.getIntInput("Nhập năm sản xuất: ");
        String owner = InputValidator.getStringInput("Nhập chủ sở hữu: ");

        int seats = 0, power = 0;
        double load = 0.0;
        String carType = "";

        if (type == 1) {
            seats = InputValidator.getIntInput("Nhập số chỗ: ");
            carType = InputValidator.getStringInput("Nhập kiểu xe: ");
        } else if (type == 2) {
            load = InputValidator.getIntInput("Nhập tải trọng (tấn): ");
        } else if (type == 3) {
            power = InputValidator.getIntInput("Nhập công suất: ");
        }

        boolean success = controller.addVehicle(type, license, manufacturer, year, owner, seats, carType, load, power);
        if (success) {
            System.out.println("Thêm phương tiện thành công!");
        } else {
            System.out.println("Loại phương tiện không hợp lệ!");
        }
    }

    private void displayVehicles() {
        List<Vehicle> vehicles = controller.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("Danh sách phương tiện trống.");
        } else {
            for (Vehicle vehicle : vehicles) {
                vehicle.displayInfo();
            }
        }
    }

    private void deleteVehicle() {
        String license = InputValidator.getStringInput("Nhập biển số cần xóa: ");
        boolean isDeleted = controller.deleteVehicle(license);
        if (isDeleted) {
            System.out.println("Xóa phương tiện thành công.");
        } else {
            System.out.println("Không tìm thấy phương tiện có biển số này.");
        }
    }

    private void searchVehicle() {
        String license = InputValidator.getStringInput("Nhập biển số cần tìm: ");
        Vehicle vehicle = controller.searchVehicle(license);
        if (vehicle != null) {
            vehicle.displayInfo();
        } else {
            System.out.println("Không tìm thấy phương tiện.");
        }
    }
}
