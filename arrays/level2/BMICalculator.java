import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();

        // Initialize arrays
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        // Take input for weight and height
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            
            System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();

            // Calculate BMI
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            // Determine weight status
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }

        // Display the results
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n", (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
    }
}
