public class StringBuilderVsBuffer {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb);

        sb.insert(5, "Java");
        System.out.println("After insertion: " + sb);
        sb.delete(5, 10);
        System.out.println("After deletion: " + sb);
        sb.reverse();
        System.out.println("After reversal: " + sb);
        StringBuffer sbf = new StringBuffer("Thread");
        sbf.append(" Safety");
        System.out.println("StringBuffer: " + sbf);
    }
}
