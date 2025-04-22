import java.util.Scanner;

public class CollinearityChecker {

    // Method 1: Check collinearity using slopes
    public static boolean arePointsCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return slopeAB == slopeBC;
    }

    // Method 2: Check collinearity using area of triangle
    public static boolean arePointsCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) +
                             x2 * (y3 - y1) +
                             x3 * (y1 - y2));
        return area == 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        System.out.print("Enter x3 y3: ");
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        boolean slopeMethod = arePointsCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaMethod = arePointsCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\nUsing Slope Method: " + (slopeMethod ? "Collinear ✅" : "Not Collinear ❌"));
        System.out.println("Using Area Method: " + (areaMethod ? "Collinear ✅" : "Not Collinear ❌"));

        sc.close();
    }
}
