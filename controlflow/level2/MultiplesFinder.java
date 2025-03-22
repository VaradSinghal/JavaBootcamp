import java.util.Scanner;

class MultiplesFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();

        // Check if the number is valid
        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");
            
            // Loop from 100 down to 1
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) { // Check if i is a multiple of number
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        scanner.close();
    }
}
