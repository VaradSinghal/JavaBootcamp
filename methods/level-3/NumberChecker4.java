public class NumberChecker4 {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    public static boolean isSpy(int num) {
        int sum = 0, product = 1;
        while (num > 0) {
            int d = num % 10;
            sum += d;
            product *= d;
            num /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num));
    }

    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println("Prime: " + isPrime(num));
        System.out.println("Neon: " + isNeon(num));
        System.out.println("Spy: " + isSpy(num));
        System.out.println("Automorphic: " + isAutomorphic(num));
        System.out.println("Buzz: " + isBuzz(num));
    }
}
