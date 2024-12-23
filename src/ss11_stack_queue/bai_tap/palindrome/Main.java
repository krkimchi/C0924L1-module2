package ss11_stack_queue.bai_tap.palindrome;

public class Main {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        String test1 = "Able was I ere I saw Elba";
        String test2 = "Hello World";

        System.out.println("Chuỗi: \"" + test1 + "\"");
        System.out.println(checker.isPalindrome(test1));

        System.out.println("\nChuỗi: \"" + test2 + "\"");
        System.out.println(checker.isPalindrome(test2));

    }
}
