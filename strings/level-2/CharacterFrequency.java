public class CharacterFrequency {

    // Method to find the frequency of characters
    public static void findCharacterFrequency(String text) {
        int[] freq = new int[256]; // Array to store frequency of characters
        
        // Calculate frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        
        // Display the frequency of each character
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        String text = "hello world";
        findCharacterFrequency(text);
    }
}
