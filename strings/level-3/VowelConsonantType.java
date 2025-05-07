import java.util.Scanner;

public class VowelConsonantType {
    public static String getCharType(char ch) {
        if (Character.isLetter(ch)) {
            if ("aeiouAEIOU".indexOf(ch) >= 0) {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] classifyCharacters(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = classifyCharacters(input);
        displayTable(result);
        sc.close();
    }
}
