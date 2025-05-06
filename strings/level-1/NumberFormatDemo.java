import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate the exception
    public static void generateException(String input) {
        // This line throws NumberFormatException if input is not a number
        int number = Integer.parseInt(input);
        System.out.println("Parsed number: " + number);
    }

    // Method to handle the exception
    public static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Generic Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        String value = sc.next();
		
        // Safe with exception handling
        handleException(value);
    }
}
