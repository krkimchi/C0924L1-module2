package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc (0 đến 1000): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 1000) {
            System.out.println("Out of ability");
        } else if (number == 1000) {
            System.out.println("One thousand");
        } else {
            System.out.println(readNumber(number));
        }
    }

    public static String readNumber(int number) {
        if (number < 10) {
            return readOneDigit(number);
        } else if (number < 20) {
            return readTeen(number);
        } else if (number < 100) {
            return readTens(number);
        } else {
            return readHundreds(number);
        }
    }

    public static String readOneDigit(int number) {
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    public static String readTeen(int number) {
        switch (number) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }

    public static String readTens(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String tensString = "";
        switch (tens) {
            case 2:
                tensString = "twenty";
                break;
            case 3:
                tensString = "thirty";
                break;
            case 4:
                tensString = "forty";
                break;
            case 5:
                tensString = "fifty";
                break;
            case 6:
                tensString = "sixty";
                break;
            case 7:
                tensString = "seventy";
                break;
            case 8:
                tensString = "eighty";
                break;
            case 9:
                tensString = "ninety";
                break;
        }
        if (ones != 0) {
            return tensString + " " + readOneDigit(ones);
        } else {
            return tensString;
        }
    }

    public static String readHundreds(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;
        String hundredsString = readOneDigit(hundreds) + " hundred";
        if (remainder != 0) {
            return hundredsString + " and " + readNumber(remainder);
        } else {
            return hundredsString;
        }
    }
}
