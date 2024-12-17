package bai_tap_lam_them.utils;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }
}
