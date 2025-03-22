import java.util.Scanner;

class GreatestFactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number > 1) {
            int greatestFactor = 1; // Initialize greatest factor

            // Loop from number - 1 down to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) { // Check if i is a factor
                    greatestFactor = i; // Assign i as greatest factor
                    break; // Exit loop after finding the first (largest) factor
                }
            }

            // Display the greatest factor
            System.out.println("Greatest factor of " + number + " (excluding itself) is: " + greatestFactor);
        } else {
            System.out.println("Please enter a number greater than 1.");
        }

        scanner.close();
    }
}
