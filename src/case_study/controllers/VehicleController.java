package case_study.controllers;

import case_study.models.*;
import case_study.services.VehicleService;
import case_study.utils.FileHandler;
import case_study.views.VehicleView;

import java.util.List;

public class VehicleController {
    private final VehicleView view;
    private final VehicleService vehicleService;

    public VehicleController(VehicleView view, VehicleService vehicleService) {
        this.view = view;
        this.vehicleService = vehicleService;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMenu();
            try {
                int choice = view.getChoice(1, 4);

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
                        running = false;
                        view.printMessage("Đang thoát chương trình!");
                        break;
                    default:
                        view.printMessage("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                view.printMessage("Lỗi: " + e.getMessage());
            }
        }
    }

    private void addVehicle() {
        view.printMessage("1. Thêm xe tải");
        view.printMessage("2. Thêm ôtô");
        view.printMessage("3. Thêm xe máy");

        try {
            int choice = Integer.parseInt(view.getInput("Chọn loại phương tiện: "));
            String licensePlate = view.getInput("Nhập biển kiểm soát: ");

            List<String> manufacturers = FileHandler.readFile("manufacturer.csv");

            if (manufacturers.isEmpty()) {
                view.printMessage("Không có hãng sản xuất nào trong danh sách!");
                return;
            }

            view.printMessage("Danh sách hãng sản xuất:");
            for (int i = 0; i < manufacturers.size(); i++) {
                String[] parts = manufacturers.get(i).split(",");
                if (parts.length > 1) {
                    view.printMessage((i + 1) + ". " + manufacturers.get(i));
                }
            }

            int manufacturerChoice = -1;
            while (true) {
                try {
                    manufacturerChoice = Integer.parseInt(view.getInput("Chọn hãng sản xuất: "));
                    if (manufacturerChoice >= 1 && manufacturerChoice <= manufacturers.size()) {
                        break;
                    } else {
                        view.printMessage("Lựa chọn không hợp lệ!");
                    }
                } catch (NumberFormatException e) {
                    view.printMessage("Lỗi: Vui lòng nhập số hợp lệ!");
                }
            }

            String manufacturer = "";

            String manufacturerLine = manufacturers.get(manufacturerChoice - 1);
            String[] manufacturerData = manufacturerLine.split(",");

            if (manufacturerData.length > 1) {
                manufacturer = manufacturerData[1];
            } else {
                manufacturer = "Không xác định";
            }

            int productionYear = Integer.parseInt(view.getInput("Nhập năm sản xuất: "));
            String owner = view.getInput("Nhập chủ sở hữu: ");

            Vehicle vehicle;
            String fileName;

            if (choice == 1) {
                double payload = Double.parseDouble(view.getInput("Nhập trọng tải: "));
                vehicle = new Truck(licensePlate, manufacturer, productionYear, owner, payload);
                fileName = "trucks.csv";
            } else if (choice == 2) {
                String carType = view.getInput("Nhập kiểu xe: ");
                int seats = Integer.parseInt(view.getInput("Nhập số chỗ ngồi: "));
                vehicle = new Car(licensePlate, manufacturer, productionYear, owner, carType, seats);
                fileName = "cars.csv";
            } else if (choice == 3) {
                int engineCapacity = Integer.parseInt(view.getInput("Nhập công suất: "));
                vehicle = new Motorcycle(licensePlate, manufacturer, productionYear, owner, engineCapacity);
                fileName = "motorcycles.csv";
            } else {
                view.printMessage("Lựa chọn không hợp lệ!");
                return;
            }

            vehicleService.addVehicle(vehicle, fileName);
            view.printMessage("Thêm mới phương tiện thành công!");

        } catch (NumberFormatException e) {
            view.printMessage("Lỗi: Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            view.printMessage("Đã xảy ra lỗi khi thêm phương tiện: " + e.getMessage());
        }
    }

    private void displayVehicles() {
        view.printMessage("1. Hiển thị xe tải");
        view.printMessage("2. Hiển thị ôtô");
        view.printMessage("3. Hiển thị xe máy");

        try {
            int choice = Integer.parseInt(view.getInput("Chọn loại phương tiện: "));
            String fileName;

            switch (choice) {
                case 1:
                    fileName = "trucks.csv";
                    break;
                case 2:
                    fileName = "cars.csv";
                    break;
                case 3:
                    fileName = "motorcycles.csv";
                    break;
                default:
                    view.printMessage("Lựa chọn không hợp lệ!");
                    return;
            }

            List<String> vehicles = vehicleService.getAllVehicles(fileName);

            if (vehicles.isEmpty()) {
                view.printMessage("Không có phương tiện nào trong danh sách.");
            } else {
                vehicles.forEach(view::printMessage);
            }

        } catch (NumberFormatException e) {
            view.printMessage("Lỗi: Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            view.printMessage("Đã xảy ra lỗi khi hiển thị phương tiện: " + e.getMessage());
        }
    }

    private void deleteVehicle() {
        view.printMessage("1. Xóa xe tải");
        view.printMessage("2. Xóa ôtô");
        view.printMessage("3. Xóa xe máy");

        try {
            int choice = view.getChoice(1, 3);
            String fileName;

            if (choice == 1) {
                fileName = "trucks.csv";
            } else if (choice == 2) {
                fileName = "cars.csv";
            } else if (choice == 3) {
                fileName = "motorcycles.csv";
            } else {
                view.printMessage("Lựa chọn không hợp lệ!");
                return;
            }

            String licensePlate = view.getInput("Nhập biển kiểm soát phương tiện cần xóa: ");
            String confirmation = view.getInput("Bạn có chắc chắn muốn xóa phương tiện này? (yes/no): ");

            if (!confirmation.equalsIgnoreCase("yes")) {
                view.printMessage("Hủy thao tác xóa.");
                return;
            }

            if (vehicleService.deleteVehicle(licensePlate, fileName)) {
                view.printMessage("Đã xóa thành công phương tiện!");
            } else {
                view.printMessage("Không tìm thấy phương tiện với biển kiểm soát: " + licensePlate);
            }

        } catch (NumberFormatException e) {
            view.printMessage("Lỗi: Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            view.printMessage("Đã xảy ra lỗi khi xóa phương tiện: " + e.getMessage());
        }
    }
}
