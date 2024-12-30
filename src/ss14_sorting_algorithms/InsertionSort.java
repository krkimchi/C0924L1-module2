package ss14_sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 2, 8, 5, 1, 6, 4, 15};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
}
