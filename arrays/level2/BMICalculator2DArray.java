import java.util.Scanner;

public class BMICalculator2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();

        // Initialize arrays
        double[][] personData = new double[number][3]; // 0: Weight, 1: Height, 2: BMI
        String[] weightStatus = new String[number];

        // Take input for weight and height with validation
        for (int i = 0; i < number; i++) {
            do {
                System.out.print("Enter positive weight (in kg) for person " + (i + 1) + ": ");
                personData[i][0] = scanner.nextDouble();
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter positive height (in meters) for person " + (i + 1) + ": ");
                personData[i][1] = scanner.nextDouble();
            } while (personData[i][1] <= 0);

            // Calculate BMI
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display the results
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n", (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
}
