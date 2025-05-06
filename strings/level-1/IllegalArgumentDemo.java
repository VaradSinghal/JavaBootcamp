import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        // This will cause an IllegalArgumentException
        System.out.println("Substring (5, 2): " + text.substring(5, 2));
    }

    // Method to handle the exception
    public static void handleException(String text) {
        try {
            System.out.println("Substring (5, 2): " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Generic Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();



        // Safe with exception handling
        handleException(input);
    }
}
