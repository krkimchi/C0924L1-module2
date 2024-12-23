package ss11_stack_queue.bai_tap.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeChecker {
    public String isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                char normalizedChar = Character.toLowerCase(c);
                stack.push(normalizedChar);
                queue.offer(normalizedChar);
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return "Chuỗi không phải Palindrome";
            }
        }
        return "Chuỗi là Palindrome";
    }
}
