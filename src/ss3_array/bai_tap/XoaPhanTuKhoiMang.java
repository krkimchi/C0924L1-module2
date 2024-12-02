package ss3_array.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        // Bước 1: Khai báo và khởi tạo mảng số nguyên gồm N phần tử cho trước.
        int[] arr = {1, 2, 3, 4, 5};
        int N = arr.length;

        System.out.print("Mảng ban đầu: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Bước 2: Nhập X là phần tử cần xoá
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xóa: ");
        int X = scanner.nextInt();

        // Bước 3: Tìm X xem có xuất hiện trong mảng không. Nếu xuất hiện chỉ ra vị trí của X. Giả sử vị trí này là: index_del
        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == X) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử " + X + " không tồn tại trong mảng.");
        } else {
            // Bước 4: Thực hiện xoá phần tử X khỏi mảng
            for (int i = index_del; i < N - 1; i++) {
                arr[i] = arr[i + 1];
            }
            // Bước 5:  Kết thúc duyệt mảng. In ra mảng.
            System.out.print("Mảng sau khi xóa phần tử: ");
            for (int i = 0; i < N - 1; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}

