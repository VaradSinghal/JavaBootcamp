import java.util.Scanner;

class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            for (int i = 1; i <= number; i++) { // Loop from 1 to number (inclusive)
                if (number % i == 0) { // Check if i is a factor
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        scanner.close();
    }
}
