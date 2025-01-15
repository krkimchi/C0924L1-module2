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

    public int getChoice() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.print("Vui lòng nhập một số hợp lệ: ");
            } else {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.print("Lựa chọn không hợp lệ. Vui lòng nhập số: ");
                }
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
