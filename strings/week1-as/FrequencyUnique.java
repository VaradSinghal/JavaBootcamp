    import java.util.*;

    public class FrequencyUnique {
        public static char[] uniqueChars(String s) {
            int n = s.length(), idx = 0;
            char[] temp = new char[n];
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                boolean unique = true;
                for (int j = 0; j < i; j++) if (s.charAt(j) == c) unique = false;
                if (unique) temp[idx++] = c;
            }
            return Arrays.copyOf(temp, idx);
        }

        public static String[][] frequency(String s) {
            int[] freq = new int[256];
            for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
            char[] unique = uniqueChars(s);
            String[][] result = new String[unique.length][2];
            for (int i = 0; i < unique.length; i++) {
                result[i][0] = String.valueOf(unique[i]);
                result[i][1] = String.valueOf(freq[unique[i]]);
            }
            return result;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[][] res = frequency(s);
            for (String[] row : res) System.out.println(row[0] + " -> " + row[1]);
        }
    }
