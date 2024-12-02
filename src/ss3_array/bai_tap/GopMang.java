package ss3_array.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Tạo 2 mảng số với kích thước cho trước
        System.out.print("Nhập kích thước mảng 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.print("Nhập kích thước mảng 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        // Bước 2: Sử dụng vòng lặp nhập giá trị cho các phần tử trong mảng
        System.out.println("Nhập các phần tử của mảng 1: ");
        for (int i = 0; i < size1; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }

        System.out.println("Nhập các phần tử của mảng 2:");
        for (int i = 0; i < size2; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }

        // Bước 3: Tạo mảng thứ 3 có kích thước bằng kích thước mảng 1 + kích thước mảng 2
        int[] array3 = new int[size1 + size2];

        // Bước 4: Sử dụng vòng lặp để duyệt các phần tử trong mảng 1. Lấy từng phần tử trong mảng 1 gán vào từng phần tử trong mảng thứ 3, tính từ phần tử đầu tiên.
        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }

        // Bước 5: Sử dụng vòng lặp để duyệt các phần tử trong mảng 2. Lấy từng phần tử trong mảng 2 gán vào phần tử tiếp theo của mảng 3, tính từ phần tử array3[array2.length]
        for (int i = 0; i < size2; i++) {
            array3[size1 + i] = array2[i];
        }

        System.out.println("Mảng sau khi gộp:");
        for (int num : array3) {
            System.out.print(num + " ");
        }
    }
}
