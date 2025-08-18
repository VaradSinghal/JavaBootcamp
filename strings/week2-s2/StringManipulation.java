import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        String replaced = trimmed.replace(" ", "_");
        System.out.println("Spaces -> _: " + replaced);

        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("No digits: " + noDigits);

        String[] words = trimmed.split("\\s+");
        System.out.println("Split: " + Arrays.toString(words));

        String rejoined = String.join(" | ", words);
        System.out.println("Joined: " + rejoined);

        String noPunct = removePunctuation(trimmed);
        System.out.println("No punctuation: " + noPunct);

        String capitalized = capitalizeWords(noPunct);
        System.out.println("Capitalized: " + capitalized);

        String reversed = reverseWords(noPunct);
        System.out.println("Reversed: " + reversed);

        System.out.println("Word Frequency:");
        countWordFrequency(noPunct);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[\\p{Punct}]", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWords(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        visited[j] = true;
                    }
                }
                System.out.println(words[i] + " : " + count);
            }
        }
    }
}
