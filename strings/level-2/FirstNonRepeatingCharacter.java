public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character
    public static char firstNonRepeatingCharacter(String text) {
        int[] freq = new int[256]; // Array to store character frequency

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character
    }

    public static void main(String[] args) {
        String text = "swiss";
        char result = firstNonRepeatingCharacter(text);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
