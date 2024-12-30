package ss13_searching_algorithms.bai_tap;

import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi bất kỳ: ");
        String str = scanner.nextLine();

        String result = "";
        String tempResult = "";

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (tempResult.isEmpty() || currentChar > tempResult.charAt(tempResult.length() - 1)) {
                tempResult += currentChar;
            } else {
                if (tempResult.length() > result.length()) {
                    result = tempResult;
                }
                tempResult = "" + currentChar;
            }
        }
        if (tempResult.length() > result.length()) {
            result = tempResult;
        }

        System.out.println("Chuỗi tăng dần lớn nhất là: " + result);
    }
}
