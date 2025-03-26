import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        number = Math.abs(number); // Handle negative numbers

        // Find the count of digits in the number
        int temp = number;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Store digits in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Calculate frequency of each digit
        int[] frequency = new int[10]; // Array to store frequencies of digits 0-9
        for (int digit : digits) {
            frequency[digit]++;
        }

        // Display frequency of each digit
        System.out.println("\nDigit\tFrequency");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + "\t" + frequency[i]);
            }
        }
    }
}
