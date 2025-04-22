import java.util.Arrays;

public class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] nums) {
        int min = nums[0], max = nums[0], sum = 0;
        for (int n : nums) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        double avg = sum / (double) nums.length;
        return new double[]{ avg, min, max };
    }

    public static void main(String[] args) {
        int[] randomNums = generate4DigitRandomArray(5);
        System.out.println("Generated: " + Arrays.toString(randomNums));

        double[] stats = findAverageMinMax(randomNums);
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }
}
