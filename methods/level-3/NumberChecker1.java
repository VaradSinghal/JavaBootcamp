public class NumberChecker1 {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int num, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == num;
    }

    public static void findLargestSmallest(int[] digits) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }

            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
        System.out.println("Smallest: " + smallest + ", Second Smallest: " + secondSmallest);
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);
        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Duck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong: " + isArmstrong(number, digits));
        findLargestSmallest(digits);
    }
}
