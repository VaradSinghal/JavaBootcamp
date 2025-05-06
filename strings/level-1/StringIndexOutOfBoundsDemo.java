import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String input) {
        // Intentionally accessing invalid index
        System.out.println("Character at index 100: " + input.charAt(100));
    }

    // Method to handle the exception
    public static void handleException(String input) {
        try {
            System.out.println("Character at index 100: " + input.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Generic Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();


        // Safe execution with exception handling
        handleException(text);
    }
}
