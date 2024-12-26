package ss13_thuat_toan.bai_tap;

import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi bất kỳ: ");
        String str = scanner.nextLine();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            boolean found = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    found = true;
                    break;
                }
            }
            if (!found && (result.isEmpty() || currentChar > result.charAt(result.length() - 1))) {
                result += currentChar;
            }
        }

        System.out.println("Chuỗi tăng dần lớn nhất là: " + result);
    }
}
