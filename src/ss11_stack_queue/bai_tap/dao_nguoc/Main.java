package ss11_stack_queue.bai_tap.dao_nguoc;

public class Main {
    public static void main(String[] args) {
        ReverseUtil reverseUtil = new ReverseUtil();

        int[] array = {10, 20, 30, 40, 50, 60};
        System.out.print("Original Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        reverseUtil.reverseArray(array);

        System.out.print("\nReversed Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        String input = "Hello World";
        System.out.println("\n\nOriginal String: " + input);
        String reversedString = reverseUtil.reverseString(input);
        System.out.println("Reversed String: " + reversedString);
    }
}
