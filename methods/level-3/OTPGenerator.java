import java.util.*;

public class OTPGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static String generateOTP() {
        int otp = 100000 + (int)(Math.random() * 900000);
        return String.valueOf(otp);
    }

    // Method to generate 10 OTPs and store in array
    public static String[] generateMultipleOTPs(int count) {
        String[] otps = new String[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if OTPs are unique
    public static boolean areOTPsUnique(String[] otps) {
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(otps));
        return uniqueSet.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] otps = generateMultipleOTPs(10);
        System.out.println("Generated OTPs:");
        for (String otp : otps) {
            System.out.println(otp);
        }

        boolean unique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + (unique ? "Yes ✅" : "No ❌"));
    }
}
