import java.util.Scanner;

class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer (base number): ");
        int number = scanner.nextInt();
        System.out.print("Enter a positive integer (exponent): ");
        int power = scanner.nextInt();

        // Check if inputs are valid
        if (number >= 0 && power >= 0) {
            int result = 1; // Initialize result
            int counter = 0; // Counter variable

            // Loop until counter reaches power
            while (counter < power) {
                result *= number; // Multiply result by number
                counter++; // Increment counter
            }

            // Display the result
            System.out.println(number + "^" + power + " = " + result);
        } else {
            System.out.println("Please enter non-negative integers.");
        }

        scanner.close();
    }
}
