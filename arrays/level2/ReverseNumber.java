import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the count of digits
        int tempNumber = number;
        int count = 0;
        while (tempNumber != 0) {
            count++;
            tempNumber /= 10;
        }

        // Store the digits in an array
        int[] digits = new int[count];
        tempNumber = number;
        for (int i = 0; i < count; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        // Display the reversed number using the array
        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}

		
		