import java.util.Scanner;

public class UpperCaseConversion {

    // Method to convert text to uppercase using charAt()
    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32); // Convert to uppercase
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings using charAt
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String manualUpper = convertToUpperCase(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("Manual Uppercase: " + manualUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Are they equal? " + compareStrings(manualUpper, builtInUpper));
    }
}
