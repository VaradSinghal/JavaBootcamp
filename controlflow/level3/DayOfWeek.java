import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the month, day, and year
        System.out.print("Enter month (1 for January, 2 for February, etc.): ");
        int m = scanner.nextInt();  // month

        System.out.print("Enter day: ");
        int d = scanner.nextInt();  // day

        System.out.print("Enter year: ");
        int y = scanner.nextInt();  // year

        // Apply the formula to calculate the day of the week
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;

        // Print the day of the week (0 for Sunday, 1 for Monday, ..., 6 for Saturday)
        System.out.println("The day of the week is: " + d0);

        // Close the scanner object to prevent resource leak
        scanner.close();
    }
}
