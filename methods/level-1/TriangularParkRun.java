import java.util.Scanner;

public class TriangularParkRun {
    public static int calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return (int)(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of the triangle (in meters): ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        int rounds = calculateRounds(a, b, c);
        System.out.println("Number of rounds needed to run 5 km: " + rounds);
    }
}
