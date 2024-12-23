package ss11_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

public class DecimalToBinary {
    public String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";

        String binary = "";

        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary;
    }
}
