package ss11_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {
    public String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";

        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop();
        }
        return binary;
    }
}
