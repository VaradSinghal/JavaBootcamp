import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        // Input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Handle negative numbers by converting them to positive
        number = Math.abs(number);

        // Initialize count to 0
        int count = 0;

        // Check if the number is 0 because it has exactly 1 digit
        if (number == 0) {
            count = 1;
        } else {
            // Loop to remove the last digit and increase count
            while (number != 0) {
                number /= 10;  // Remove the last digit
                count++;       // Increase the count
            }
        }

        // Display the count of digits
        System.out.println("The number has " + count + " digits.");

        scanner.close();
    }
}

