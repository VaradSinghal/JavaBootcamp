import java.util.Scanner;

class MultiplesFinderWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();

        // Check if the number is valid
        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");

            int counter = 100; // Start from 100

            // Loop until counter is greater than 1
            while (counter > 1) {
                if (counter % number == 0) { // Check if counter is a multiple
                    System.out.println(counter);
                }
                counter--; // Decrement counter
            }
        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        scanner.close();
    }
}
