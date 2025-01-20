package case_study.views;

import java.util.Scanner;

public class VehicleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
        System.out.println("1. Thêm mới phương tiện");
        System.out.println("2. Hiển thị phương tiện");
        System.out.println("3. Xóa phương tiện");
        System.out.println("4. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public int getChoice(int min, int max) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice < min || choice > max) {
                    System.out.print("Lựa chọn không hợp lệ. Vui lòng nhập từ " + min + " đến " + max + ": ");
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.print("Lựa chọn không hợp lệ. Vui lòng nhập số: ");
            }
        }
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        String input;
        while ((input = scanner.nextLine()).isEmpty()) {
            System.out.print("Dữ liệu không được để trống. " + prompt);
        }
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
