import java.util.Scanner;
import java.util.Random;

public class StudentGrades {
    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(101); // Physics
            marks[i][1] = rand.nextInt(101); // Chemistry
            marks[i][2] = rand.nextInt(101); // Math
        }
        return marks;
    }

    public static double[][] calculateScores(int[][] marks) {
        double[][] scores = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            scores[i][0] = total;
            scores[i][1] = Math.round(average * 100.0) / 100.0;
            scores[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return scores;
    }

    public static String[] calculateGrades(double[][] scores) {
        String[] grades = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            double percentage = scores[i][2];
            if (percentage >= 90) grades[i] = "A+";
            else if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else grades[i] = "Fail";
        }
        return grades;
    }

    public static void displayScorecard(int[][] marks, double[][] scores, String[] grades) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.println("S.No\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f\t\t%s\n", 
                              (i + 1), marks[i][0], marks[i][1], marks[i][2], 
                              scores[i][0], scores[i][1], scores[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] scores = calculateScores(marks);
        String[] grades = calculateGrades(scores);

        displayScorecard(marks, scores, grades);
        sc.close();
    }
}
