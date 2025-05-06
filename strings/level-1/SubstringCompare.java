import java.util.Scanner;

public class SubstringCompare {

    // Method to manually create a substring using charAt()
    public static String manualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String manual = manualSubstring(text, start, end);
        String builtIn = text.substring(start, end);

        boolean isEqual = compareStrings(manual, builtIn);

        System.out.println("Manual Substring: " + manual);
        System.out.println("Built-in Substring: " + builtIn);
        System.out.println("Are they equal? " + isEqual);
    }
}
