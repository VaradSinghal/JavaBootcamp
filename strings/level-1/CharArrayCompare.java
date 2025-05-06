import java.util.Scanner;

public class CharArrayCompare {

    // Method to manually convert string to char array
    public static char[] manualToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] manualArray = manualToCharArray(input);
        char[] builtInArray = input.toCharArray();

        boolean isEqual = compareCharArrays(manualArray, builtInArray);

        System.out.println("Manual Array: ");
        for (char c : manualArray) System.out.print(c + " ");
        System.out.println("\nBuilt-in Array: ");
        for (char c : builtInArray) System.out.print(c + " ");
        System.out.println("\nAre arrays equal? " + isEqual);
    }
}
