import java.util.Scanner;

public class LeapYearr {
    public static void main(String[] args) {
        // Input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check for the Gregorian calendar validity
        if (year >= 1582 && 
            (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else if (year >= 1582) {
            System.out.println(year + " is not a Leap Year.");
        } else {
            System.out.println("The year must be greater than or equal to 1582.");
        }

        scanner.close();
    }
}
