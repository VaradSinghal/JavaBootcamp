import java.util.Random;
import java.util.Scanner;

public class StudentScoreCalculator {

    // Method to generate random 2-digit scores for Physics, Chemistry, and Maths for all students
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // PCM scores for each student
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(100); // Physics score (0-99)
            scores[i][1] = rand.nextInt(100); // Chemistry score (0-99)
            scores[i][2] = rand.nextInt(100); // Maths score (0-99)
        }
        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; // Total, Average, Percentage for each student
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    // Method to display the scorecard in tabular format
    public static void displayScoreCard(int[][] scores, double[][] results) {
        System.out.println("\nStudent Scorecard:");
        System.out.println("------------------------------------------------------------");
        System.out.println("Student | Physics | Chemistry | Maths | Total | Average | Percentage");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%8d | %7d | %9d | %5d | %5.2f | %7.2f | %10.2f%%\n", 
                              (i + 1), 
                              scores[i][0], scores[i][1], scores[i][2], 
                              results[i][0], results[i][1], results[i][2]);
        }

        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        // Generate scores for each student
        int[][] scores = generateScores(numStudents);

        // Calculate results for each student (Total, Average, Percentage)
        double[][] results = calculateResults(scores);

        // Display the scorecard
        displayScoreCard(scores, results);

        sc.close();
    }
}
