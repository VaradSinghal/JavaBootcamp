import java.util.Arrays;

public class AnagramChecker {

    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // Main method
    public static void main(String[] args) {
        String text1 = "listen";
        String text2 = "silent";
        boolean result = areAnagrams(text1, text2);
        System.out.println("Are anagrams: " + result);
    }
}
