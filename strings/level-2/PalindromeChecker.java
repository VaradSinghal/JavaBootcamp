public class PalindromeChecker {

    // Method to check palindrome using recursion
    public static boolean isPalindrome(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindrome(text, start + 1, end - 1);
    }

    // Main method
    public static void main(String[] args) {
        String text = "madam";
        boolean result = isPalindrome(text, 0, text.length() - 1);
        System.out.println("Is palindrome: " + result);
    }
}
