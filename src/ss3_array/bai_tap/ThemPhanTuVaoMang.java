package ss3_array.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        // Bước 1: Khai báo và khởi tạo mảng số nguyên gồm N phần tử cho trước.
        int[] arr = {1, 2, 3, 4, 5};
        int N = arr.length;

        System.out.print("Mảng ban đầu: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Bước 2: Nhập X là số cần chèn
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần chèn: ");
        int X = scanner.nextInt();

        // Bước 3: Nhập vào vị trí index cần chèn X vào trong mảng
        System.out.print("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();

        // Bước 4: Nếu index <= -1 và index >= array.length – 1 thì hiển thị không chèn được phần tử vào mảng.
        if (index < 0 || index > N) {
            System.out.println("Không thể chèn phần tử tại vị trí này.");
        } else {
            // Bước 5: Thực hiện chèn phần tử X ở vị trí index vào mảng
            int[] newArr = new int[N + 1];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = X;
            for (int i = index; i < N; i++) {
                newArr[i + 1] = arr[i];
            }
            System.out.print("Mảng sau khi chèn: ");
            for (int num : newArr) {
                System.out.print(num + " ");
            }
        }
    }
}
