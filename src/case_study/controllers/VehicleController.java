package case_study.controllers;

import case_study.models.*;
import case_study.utils.FileHandler;
import case_study.views.VehicleView;

import java.util.ArrayList;
import java.util.List;

public class VehicleController {
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private final VehicleView view;

    public VehicleController(VehicleView view) {
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMenu();
            try {
                int choice = view.getChoice();

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
            } catch (NumberFormatException e) {
                view.printMessage("Lỗi: Vui lòng nhập một số hợp lệ!");
            } catch (Exception e) {
                view.printMessage("Đã xảy ra lỗi: " + e.getMessage());
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
            if (isDuplicate(licensePlate)) {
                view.printMessage("Phương tiện với biển kiểm soát này đã tồn tại!");
                return;
            }

            List<String> manufacturers = FileHandler.readFile("manufacturer.csv");
            view.printMessage("Danh sách hãng sản xuất:");
            manufacturers.forEach(view::printMessage);

            String manufacturer = view.getInput("Nhập hãng sản xuất (Mã hoặc Tên): ");
            int productionYear = Integer.parseInt(view.getInput("Nhập năm sản xuất: "));
            if (productionYear < 1900 || productionYear > 2025) {
                view.printMessage("Năm sản xuất không hợp lệ!");
                return;
            }
            String owner = view.getInput("Nhập chủ sở hữu: ");

            Vehicle vehicle;

            switch (choice) {
                case 1:
                    double payload = Double.parseDouble(view.getInput("Nhập trọng tải: "));
                    vehicle = new Truck(licensePlate, manufacturer, productionYear, owner, payload);
                    FileHandler.writeFile("trucks.csv", vehicle.toString());
                    break;
                case 2:
                    String carType = view.getInput("Nhập kiểu xe: ");
                    int seats = Integer.parseInt(view.getInput("Nhập số chỗ ngồi: "));
                    vehicle = new Car(licensePlate, manufacturer, productionYear, owner, carType, seats);
                    FileHandler.writeFile("cars.csv", vehicle.toString());
                    break;
                case 3:
                    int engineCapacity = Integer.parseInt(view.getInput("Nhập công suất: "));
                    vehicle = new Motorcycle(licensePlate, manufacturer, productionYear, owner, engineCapacity);
                    FileHandler.writeFile("motorcycles.csv", vehicle.toString());
                    break;
                default:
                    view.printMessage("Lựa chọn không hợp lệ!");
                    return;
            }

            vehicleList.add(vehicle);
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

            List<String> data;
            switch (choice) {
                case 1:
                    data = FileHandler.readFile("trucks.csv");
                    break;
                case 2:
                    data = FileHandler.readFile("cars.csv");
                    break;
                case 3:
                    data = FileHandler.readFile("motorcycles.csv");
                    break;
                default:
                    view.printMessage("Lựa chọn không hợp lệ!");
                    return;
            }

            if (data.isEmpty()) {
                view.printMessage("Không có phương tiện nào trong danh sách.");
            } else {
                data.forEach(view::printMessage);
            }
        } catch (NumberFormatException e) {
            view.printMessage("Lỗi: Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            view.printMessage("Đã xảy ra lỗi khi hiển thị phương tiện: " + e.getMessage());
        }
    }

    private void deleteVehicle() {
        try {
            String regex = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";

            String licensePlate = view.getInput("Nhập biển kiểm soát phương tiện cần xóa: ");

            if (!licensePlate.matches(regex)) {
                view.printMessage("Lỗi: Biển kiểm soát không đúng định dạng! Ví dụ hợp lệ: 43A-123.45");
                return;
            }
            boolean found = false;
            List<String> vehicles = FileHandler.readFile("trucks.csv");
            for (String line : vehicles) {
                if (line.startsWith(licensePlate)) {
                    String confirmation = view.getInput("Bạn có chắc chắn muốn xóa phương tiện này? (Yes/No): ");
                    if (confirmation.equalsIgnoreCase("Yes")) {
                        vehicles.remove(line);
                        FileHandler.writeFile("trucks.csv", String.join("\n", vehicles));
                        view.printMessage("Đã xóa thành công phương tiện!");
                    } else {
                        view.printMessage("Hủy xóa phương tiện.");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                view.printMessage("Không tìm thấy phương tiện với biển kiểm soát: " + licensePlate);
            }

        } catch (Exception e) {
            view.printMessage("Đã xảy ra lỗi khi xóa phương tiện: " + e.getMessage());
        }
    }


    private boolean isDuplicate(String licensePlate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }
}
