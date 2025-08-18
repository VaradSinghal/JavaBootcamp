import java.util.*;

public class UniqueCharacters {
    public static int stringLength(String s) {
        int len = 0;
        try { while (true) { s.charAt(len); len++; } }
        catch (Exception e) {}
        return len;
    }

    public static char[] uniqueChars(String s) {
        int n = stringLength(s), idx = 0;
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) if (s.charAt(j) == c) unique = false;
            if (unique) temp[idx++] = c;
        }
        return Arrays.copyOf(temp, idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] unique = uniqueChars(s);
        System.out.println(Arrays.toString(unique));
    }
}
