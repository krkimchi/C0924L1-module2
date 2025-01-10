package ss18_string_regex.bai_tap;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập vào số điện thoại: ");
            String phoneNumber = scanner.nextLine();

            if (phoneNumber.trim().isEmpty()) {
                System.out.print("Số điện thoại không được để trống!");
            } else if (isValidPhoneNumber(phoneNumber)) {
                System.out.println("Số điện thoại hợp lệ!");
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ!");
            }
        }
        scanner.close();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return phoneNumber.matches(regex);
    }
}
