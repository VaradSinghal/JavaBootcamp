import java.util.*;

public class Height {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height (in cm) of " + friends[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("Youngest Friend: " + friends[youngestIndex]);
        System.out.println("Tallest Friend: " + friends[tallestIndex]);
    }
}
