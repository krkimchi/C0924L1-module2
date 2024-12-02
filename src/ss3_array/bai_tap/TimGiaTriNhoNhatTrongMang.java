package ss3_array.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo mảng số nguyên với SIZE phần tử
        System.out.print("Nhập kích thước của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Bước 2: Nhập giá trị cho các phần tử trong mảng từ bàn phím
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Bước 3: Gọi phần tử đầu tiên trong mảng là phần tử có giá trị nhỏ nhất
        int min = array[0];

        // Bước 4: Duyệt mảng từ phần tử thứ 2 đến hết mảng và so sánh lần lượt các phần tử tiếp theo với giá trị nhỏ nhất
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        // Bước 5: Kết thúc duyệt mảng. In ra giá trị nhỏ nhất
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
    }
}
