import java.util.Scanner;

public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number > 1) {
            int greatestFactor = 1; // Initialize greatest factor
            int counter = number - 1; // Start counter from number - 1

            // Loop until counter reaches 1
            while (counter >= 1) {
                if (number % counter == 0) { // Check if counter is a factor
                    greatestFactor = counter; // Assign counter as greatest factor
                    break; // Exit loop after finding the first (largest) factor
                }
                counter--; // Decrement counter
            }

            // Display the greatest factor
            System.out.println("Greatest factor of " + number + " (excluding itself) is: " + greatestFactor);
        } else {
            System.out.println("Please enter a number greater than 1.");
        }

        scanner.close();
    }
}
