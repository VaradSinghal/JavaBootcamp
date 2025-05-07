import java.util.Scanner;

public class ShortestLongestWord {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] findShortestLongest(String[] words) {
        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (getLength(word) < getLength(shortest)) shortest = word;
            if (getLength(word) > getLength(longest)) longest = word;
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");
        String[] result = findShortestLongest(words);

        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Longest Word: " + result[1]);

        sc.close();
    }
}
