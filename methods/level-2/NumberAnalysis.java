import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            nums[i] = sc.nextInt();

            if (!isPositive(nums[i])) {
                System.out.println("Negative");
            } else {
                System.out.print("Positive ");
                System.out.println(isEven(nums[i]) ? "Even" : "Odd");
            }
        }

        int result = compare(nums[0], nums[4]);
        if (result == 0) System.out.println("First and last are equal.");
        else if (result == 1) System.out.println("First is greater than last.");
        else System.out.println("First is less than last.");
    }
}
