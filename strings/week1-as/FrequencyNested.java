import java.util.*;

public class FrequencyNested {
    public static String[] frequency(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) if (chars[i] != '0') list.add(chars[i] + " -> " + freq[i]);
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (String res : frequency(s)) System.out.println(res);
    }
}
