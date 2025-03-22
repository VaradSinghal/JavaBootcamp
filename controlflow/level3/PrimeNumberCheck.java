import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        // Input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is greater than 1
        if (number <= 1) {
            System.out.println(number + " is not a Prime Number.");
        } else {
            // Boolean variable to store if the number is prime or not
            boolean isPrime = true;

            // Loop through numbers from 2 to sqrt(number) to check divisibility
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {  // If remainder is 0, it means the number is divisible by i
                    isPrime = false;
                    break;  // Exit the loop as we know the number is not prime
                }
            }

            // Check the result of the isPrime boolean variable
            if (isPrime) {
                System.out.println(number + " is a Prime Number.");
            } else {
                System.out.println(number + " is not a Prime Number.");
            }
        }

        scanner.close();
    }
}
