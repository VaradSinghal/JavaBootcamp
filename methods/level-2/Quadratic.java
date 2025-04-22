import java.util.Scanner;

public class Quadratic {

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            return new double[]{
                (-b + Math.sqrt(delta)) / (2 * a),
                (-b - Math.sqrt(delta)) / (2 * a)
            };
        } else if (delta == 0) {
            return new double[]{ -b / (2 * a) };
        } else {
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) System.out.println("No real roots.");
        else {
            for (int i = 0; i < roots.length; i++)
                System.out.println("Root " + (i+1) + ": " + roots[i]);
        }
    }
}
