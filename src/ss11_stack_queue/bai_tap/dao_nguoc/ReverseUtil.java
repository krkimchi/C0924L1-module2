package ss11_stack_queue.bai_tap.dao_nguoc;

import java.util.Stack;

public class ReverseUtil {
    public int[] reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        return arr;
    }

    public String reverseString(String input) {
        Stack<String> stack = new Stack<>();

        String[] words = input.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
            if (!stack.isEmpty()) {
                result += " ";
            }
        }

        return result;
    }
}
