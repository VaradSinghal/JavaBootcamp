import java.util.Random;

public class FootballTeamHeights {

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        // Generate random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101);
        }

        System.out.println("Heights of players:");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        int sum = getSum(heights);
        double mean = getMean(sum, heights.length);
        int min = getMinHeight(heights);
        int max = getMaxHeight(heights);

        System.out.println("Sum of heights: " + sum);
        System.out.println("Mean height: " + mean);
        System.out.println("Shortest height: " + min);
        System.out.println("Tallest height: " + max);
    }

    public static int getSum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    public static double getMean(int sum, int count) {
        return (double) sum / count;
    }

    public static int getMinHeight(int[] arr) {
        int min = arr[0];
        for (int height : arr) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }

    public static int getMaxHeight(int[] arr) {
        int max = arr[0];
        for (int height : arr) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}
