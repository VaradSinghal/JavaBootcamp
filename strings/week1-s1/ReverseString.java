public class ReverseString {
    public static String reverse(String input) {
        if (input == null) {
            System.out.println("null");
            return null;
        }
        if (input.isEmpty()) {
            System.out.println("empty");
            return input;
        }

        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }
    public static void main(String[] args) {
        String input = null;
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
