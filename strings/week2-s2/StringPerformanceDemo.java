public class StringPerformanceDemo {
    public static void main(String[] args) {
        int iterations = 5000;
        String text = "Java";
        System.out.println("Performance Test");
        System.out.println("Iterations: " + iterations);

        long start = System.currentTimeMillis();
        String result1="";
        for (int i = 0; i < iterations; i++) {
            result1 += text;
            
        }
        long stringTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long stringBuilderTime = System.currentTimeMillis() - start;

        System.out.println("String Concatenation Time: " + stringTime + " ms");
        System.out.println("StringBuilder Time: " + stringBuilderTime + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long stringBufferTime = System.currentTimeMillis() - start;

        System.out.println("StringBuffer Time: " + stringBufferTime + " ms");
    }
}
