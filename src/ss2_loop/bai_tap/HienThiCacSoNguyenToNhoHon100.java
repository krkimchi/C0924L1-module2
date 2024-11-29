package ss2_loop.bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int num = 2;
        while (num < 100) {
            boolean isPrime = true;
            int i = 2;
            while (i <= Math.sqrt(num)) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
            if (isPrime) {
                System.out.println(num + " ");
            }
            num++;
        }
    }
}

