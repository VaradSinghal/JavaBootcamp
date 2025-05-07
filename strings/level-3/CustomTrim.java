import java.util.Scanner;

public class CustomTrim {
    public static String customTrim(String str) {
        int start = 0, end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();

        String trimmed = customTrim(input);
        System.out.println("Custom Trimmed: [" + trimmed + "]");
        System.out.println("Built-in Trimmed: [" + input.trim() + "]");
        
        System.out.println("Are both equal? " + trimmed.equals(input.trim()));
        sc.close();
    }
}
