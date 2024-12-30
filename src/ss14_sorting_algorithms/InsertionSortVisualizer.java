package ss14_sorting_algorithms;

import java.util.Arrays;

public class InsertionSortVisualizer {
    public static void main(String[] args) {
        int[] arr = {12, 2, 8, 5, 1, 6, 4, 15};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println("Bước " + i + ": " + Arrays.toString(arr));
        }
        System.out.println("\nMảng sau khi sắp xếp: " + Arrays.toString(arr));
    }
}
