package ss11_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DecimalToBinary converter = new DecimalToBinary();

        int num = 30;
        String result = converter.decimalToBinary(num);

        System.out.print("Decimal: " + num);
        System.out.print("\nBinary: " + result);

    }
}
