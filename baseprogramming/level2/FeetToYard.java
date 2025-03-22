import java.util.Scanner;

public class FeetToYard{
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter the distance in feet: ");
        double feet = scanner.nextDouble();
        
        // Conversion factors
        double yards = feet / 3.0;
        double miles = feet / 5280.0;
        
        // Display the results
        System.out.println(feet + " feet is equivalent to:");
        System.out.println(yards + " yards");
        System.out.println(miles + " miles");
        
        // Close the scanner
        scanner.close();
    }
}
