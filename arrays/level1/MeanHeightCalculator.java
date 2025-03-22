import java.util.Scanner;

public class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11]; 
        double sum = 0.0;
        
   
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        
        scanner.close();
        
        
        double meanHeight = sum / 11;
        

        System.out.println("\nMean height of the football team: " + meanHeight);
    }
}
