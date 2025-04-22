public class NumberChecker2 {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigits(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) sum += digit;
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) sum += Math.pow(digit, 2);
        return sum;
    }

    public static boolean isHarshad(int num, int[] digits) {
        return num % sumOfDigits(digits) == 0;
    }

    public static void digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; // digit, count
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int digit : digits) freq[digit][1]++;
        for (int[] pair : freq) {
            if (pair[1] > 0)
                System.out.println("Digit: " + pair[0] + ", Frequency: " + pair[1]);
        }
    }

    public static void main(String[] args) {
        int num = 21;
        int[] digits = getDigits(num);
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Harshad: " + isHarshad(num, digits));
        digitFrequency(digits);
    }
}
