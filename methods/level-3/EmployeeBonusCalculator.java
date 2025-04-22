import java.util.Random;

public class EmployeeBonusCalculator {

    // Method to generate random salary and years of service for an employee
    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2];
        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = 10000 + (rand.nextInt(90000) + 1); // Salary between 10,000 and 100,000
            employeeData[i][1] = rand.nextInt(31); // Years of service between 0 and 30
        }
        return employeeData;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3];
        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = (yearsOfService > 5) ? 0.05 * salary : (yearsOfService < 5) ? 0.02 * salary : 0;
            double newSalary = salary + bonus;
            updatedData[i][0] = salary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }
        return updatedData;
    }

    // Method to calculate the total of old salaries, new salaries, and total bonus
    public static double[] calculateTotalAmounts(double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        for (int i = 0; i < updatedData.length; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }
        return new double[]{totalOldSalary, totalNewSalary, totalBonus};
    }

    // Method to display the tabular format of employee salaries and bonuses
    public static void displaySalaryAndBonusTable(double[][] updatedData, double[] totalAmounts) {
        System.out.println("\nEmployee Salary and Bonus Details:");
        System.out.println("------------------------------------------------------------");
        System.out.println("Employee | Old Salary | New Salary | Bonus");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < updatedData.length; i++) {
            System.out.printf("%8d | %10.2f | %10.2f | %5.2f\n", (i + 1), updatedData[i][0], updatedData[i][1], updatedData[i][2]);
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("Total    | %10.2f | %10.2f | %5.2f\n", totalAmounts[0], totalAmounts[1], totalAmounts[2]);
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int numEmployees = 10; // Number of employees
        double[][] employeeData = generateEmployeeData(numEmployees);

        // Calculate new salary and bonus for each employee
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Calculate total old salary, new salary, and total bonus
        double[] totalAmounts = calculateTotalAmounts(updatedData);

        // Display the results in tabular format
        displaySalaryAndBonusTable(updatedData, totalAmounts);
    }
}
