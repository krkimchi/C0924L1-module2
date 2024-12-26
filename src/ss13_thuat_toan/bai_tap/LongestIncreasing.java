package ss13_thuat_toan.bai_tap;

import java.util.Scanner;

public class LongestIncreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = sc.nextLine();

        long startTime = System.currentTimeMillis();

        String longestSubstring = "";
        String currentSubstring = "";

        for (int i = 0; i < str.length(); i++) {
            if (currentSubstring.isEmpty() || str.charAt(i) > currentSubstring.charAt(currentSubstring.length() - 1)) {
                currentSubstring += str.charAt(i);
            } else {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = "" + str.charAt(i);
            }
        }

        if (currentSubstring.length() > longestSubstring.length()) {
            longestSubstring = currentSubstring;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Chuỗi tăng dần dài nhất là: " + longestSubstring);

        long duration = endTime - startTime;
        System.out.println("Thời gian thực thi (milliseconds): " + duration);
    }
}
