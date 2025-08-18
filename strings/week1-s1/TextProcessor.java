import java.util.Arrays;
import java.util.Scanner;
public class TextProcessor{
    public static String cleanInput(String input) {
        if (input == null) return "";
        input = input.trim().replaceAll("\\s+", " ");
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
     public static int countWordOccurrences(String cleanedText, String searchWord) {
    if (cleanedText == null || searchWord == null) return 0;
    String[] words = cleanedText.split("\\W+");
    int count = 0;
    for (String word : words) {
        if (word.equalsIgnoreCase(searchWord)) {
            count++;
        }
    }
    return count;
}


    public static void analyzeText(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("No text provided for analysis.");
            return;
        }
        String cleanedText = cleanInput(text);
        String[] words = cleanedText.split("\\W+");
        int wordCount = words.length;
        int charCount = cleanedText.replace(" ", "").length();
        int sentenceCount = cleanedText.split("[.!?]").length;

        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count : " + charCount);
        System.out.println("Sentence Count: " + sentenceCount);
    // Count: words, sentences, characters
    // Find: longest word, most common character
    // Display statistics

    }
    
    public static String[] getWordsSorted(String text) {
        if (text == null || text.isEmpty()) return new String[0];
        String[] words = text.split("\\W+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== TEXT PROCESSOR ===");
    System.out.print("Enter a paragraph of text: ");
    String inputText = scanner.nextLine();
    String cleanedText = cleanInput(inputText);
    analyzeText(cleanedText);
    String[] sortedWords = getWordsSorted(cleanedText);
    System.out.println("Sorted Words: " + Arrays.toString(sortedWords));

    System.out.print("Enter a word to search for: ");
    String searchWord = scanner.nextLine();
    int occurrences = countWordOccurrences(cleanedText, searchWord);
    System.out.println("Occurrences of '" + searchWord + "': " + occurrences);


    scanner.close();
    }

   
}