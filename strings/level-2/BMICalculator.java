import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status
    public static String[] calculateBMI(double weight, double height) {
        double bmi = weight / ((height / 100) * (height / 100));  // Convert cm to meters
        String status = "";
        
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            status = "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obesity";
        }
        
        return new String[]{String.format("%.2f", weight), String.format("%.2f", height), String.format("%.2f", bmi), status};
    }

    // Method to calculate BMI for all persons
    public static String[][] calculateAllBMI(double[][] data) {
        String[][] result = new String[10][4];
        
        for (int i = 0; i < 10; i++) {
            result[i] = calculateBMI(data[i][0], data[i][1]);
        }
        
        return result;
    }

    // Method to display the result in tabular format
    public static void displayResult(String[][] result) {
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Height", "Weight", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10s %-10s %-10s %-10s\n", result[i][1], result[i][0], result[i][2], result[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][2]; // 10 persons, 2 columns (weight, height)
        
        // Taking user inputs
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }

        // Calculate BMI and display result
        String[][] result = calculateAllBMI(data);
        displayResult(result);
    }
}
