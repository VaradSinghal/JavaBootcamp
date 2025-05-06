import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String[] names) {
        // Accessing an index that doesn't exist
        System.out.println("Name at index 10: " + names[10]);
    }

    // Method to handle the exception
    public static void handleException(String[] names) {
        try {
            System.out.println("Name at index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Generic Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];

        System.out.println("Enter 5 names:");
        for (int i = 0; i < 5; i++) {
            names[i] = sc.next();
        }

        // Safe with exception handling
        handleException(names);
    }
}
