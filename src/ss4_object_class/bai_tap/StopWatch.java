package ss4_object_class.bai_tap;

import java.util.Random;

public class StopWatch {
    // Trường startTime và endTime là private với phương thức getter để trả về giá trị của startTime và endTime.
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    // Phương thức khởi tạo không tham số khởi tạo startTime với thời gian hiện tại của hệ thống.
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    // Phương thức start() để reset startTime về thời gian hiện tại của hệ thống.
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // Phương thức stop() để thiết đặt endTime về thời gian hiện tại của hệ thống.
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    // Phương thức getElapsedTime() trả về thời gian đã trôi qua theo số milisecond giây
    public long getElapsedTime() {
        return endTime - startTime;
    }

    // Viết chương trình đo thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số.
    public static void main(String[] args) {
        // Tạo mảng gồm 100,000 số ngẫu nhiên
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        // Tạo đối tượng StopWatch
        StopWatch stopWatch = new StopWatch();

        // Bắt đầu đo thời gian
        stopWatch.start();

        // Thực hiện thuật toán Selection Sort
        selectionSort(array);

        // Dừng đo thời gian
        stopWatch.stop();

        // Hiển thị
        System.out.println("Thời gian thực thi thuật toán Selection Sort: " + stopWatch.getElapsedTime() + " milliseconds");
    }

    // Thuật toán Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
