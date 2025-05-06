import java.util.Scanner;

public class LowerCaseConversion {

    // Method to convert text to lowercase using charAt()
    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32); // Convert to lowercase
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

        String manualLower = convertToLowerCase(text);
        String builtInLower = text.toLowerCase();

        System.out.println("Manual Lowercase: " + manualLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Are they equal? " + compareStrings(manualLower, builtInLower));
    }
}
