package ss18_string_regex.bai_tap;

import java.util.Scanner;

public class ValidateClassName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập vào tên lớp học: ");
            String className = scanner.nextLine();

            if (className.trim().isEmpty()) {
                System.out.println("Tên lớp không được để trống!");
            } else if (isValidClassName(className)) {
                System.out.println("Tên lớp hợp lệ!");
                break;
            } else {
                System.out.println("Tên không hợp lệ! Vui lòng nhập lại");
            }
        }
        scanner.close();
    }

    public static boolean isValidClassName(String className) {
        String regex = "^[CAP]\\d{4}[GHIK]$";
        return className.matches(regex);
    }
}
