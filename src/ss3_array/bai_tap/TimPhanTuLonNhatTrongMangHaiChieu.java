package ss3_array.bai_tap;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Lấy kích thước ma trận từ người dùng
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();

        // Khởi tạo ma trận
        double[][] matrix = new double[rows][cols];

        // Bước 2: Thu thập giá trị từ người dùng
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử tại [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Tìm giá trị lớn nhất trong ma trận
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất trong ma trận là: " + max);
        System.out.println("Tọa độ của giá trị lớn nhất là: [" + maxRow + "][" + maxCol + "]");
    }
}
