import java.util.Scanner;

class FactorFinderWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            int i = 1; // Counter variable

            while (i <= number) { // Loop until counter reaches number
                if (number % i == 0) { // Check if i is a factor
                    System.out.println(i);
                }
                i++; // Increment counter
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        scanner.close();
    }
}
