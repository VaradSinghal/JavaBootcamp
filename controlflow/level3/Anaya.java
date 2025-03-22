import java.util.Scanner;

public class Anaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int sum = 0;
        int originalNumber = number;
        while (number != 0) {
            sum += number % 10;  
            number /= 10;        
        }
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Anaya Number.");
        } else {
            System.out.println(originalNumber + " is not a Anaya Number.");
        }

        scanner.close();
    }
}

