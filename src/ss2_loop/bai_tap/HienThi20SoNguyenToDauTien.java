package ss2_loop.bai_tap;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int numbers = 20;
        int count = 0;
        int num = 2;

        while (count < numbers) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num + " ");
                count++;
            }
            num++;
        }
    }
}
