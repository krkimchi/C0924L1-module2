package ss2_loop.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("------Menu------");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Print Rectangle
                    System.out.print("Enter the width: ");
                    int width = scanner.nextInt();
                    System.out.print("Enter the triangleHeight: ");
                    int height = scanner.nextInt();

                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    // Print Square Triangle
                    System.out.print("Enter the height: ");
                    int triangleHeight = scanner.nextInt();

                    String[] triangleTypes = {"Bottom-left", "Top-left", "Bottom-right", "Top-right"};
                    for (String triangleType : triangleTypes) {
                        System.out.println(triangleType);
                        for (int i = 1; i <= triangleHeight; i++) {
                            switch (triangleType) {
                                case "Bottom-left":
                                    for (int j = 1; j <= i; j++) {
                                        System.out.print("$ ");
                                    }
                                    break;
                                case "Top-left":
                                    for (int j = 1; j <= (triangleHeight - i + 1); j++) {
                                        System.out.print("* ");
                                    }
                                    break;
                                case "Bottom-right":
                                    for (int j = 1; j <= (triangleHeight - i); j++) {
                                        System.out.print("  ");
                                    }
                                    for (int k = 1; k <= i; k++) {
                                        System.out.print("* ");
                                    }
                                    break;
                                case "Top-right":
                                    for (int j = 1; j <= (i - 1); j++) {
                                        System.out.print("  ");
                                    }
                                    for (int k = i; k <= triangleHeight; k++) {
                                        System.out.print("* ");
                                    }
                                    break;
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    // Print Isosceles Triangle
                    System.out.print("Enter the triangleHeight: ");
                    int isoHeight = scanner.nextInt();

                    for (int i = 1; i <= isoHeight; i++) {
                        for (int j = 1; j <= isoHeight - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("------Exit------");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
