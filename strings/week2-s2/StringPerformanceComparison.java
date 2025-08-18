public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        System.out.println("\n=== STRINGBUILDER METHODS DEMO ===");
        demonstrateStringBuilderMethods();

        System.out.println("\n=== THREAD SAFETY DEMO ===");
        demonstrateThreadSafety();

        System.out.println("\n=== STRING COMPARISON METHODS ===");
        compareStringComparisonMethods();

        System.out.println("\n=== MEMORY EFFICIENCY DEMO ===");
        demonstrateMemoryEfficiency();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: " + sb);
        sb.append(" Java");
        System.out.println("append(): " + sb);
        sb.insert(6, "Beautiful ");
        System.out.println("insert(): " + sb);
        sb.delete(6, 16);
        System.out.println("delete(): " + sb);
        sb.deleteCharAt(5);
        System.out.println("deleteCharAt(): " + sb);
        sb.reverse();
        System.out.println("reverse(): " + sb);
        sb.reverse();
        sb.replace(0, 5, "Hi");
        System.out.println("replace(): " + sb);
        sb.setCharAt(0, 'h');
        System.out.println("setCharAt(): " + sb);
        System.out.println("capacity(): " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100): " + sb.capacity());
        sb.trimToSize();
        System.out.println("trimToSize(): " + sb.capacity());
    }

    public static void demonstrateThreadSafety() {
        StringBuffer sbf = new StringBuffer("Start");
        StringBuilder sbd = new StringBuilder("Start");

        Runnable bufferTask = () -> {
            for (int i = 0; i < 100; i++) sbf.append("X");
        };
        Runnable builderTask = () -> {
            for (int i = 0; i < 100; i++) sbd.append("X");
        };

        Thread t1 = new Thread(bufferTask);
        Thread t2 = new Thread(bufferTask);
        Thread t3 = new Thread(builderTask);
        Thread t4 = new Thread(builderTask);

        t1.start(); t2.start(); t3.start(); t4.start();
        try { t1.join(); t2.join(); t3.join(); t4.join(); } catch (Exception e) {}

        System.out.println("StringBuffer length (thread-safe): " + sbf.length());
        System.out.println("StringBuilder length (not thread-safe): " + sbd.length());
    }

    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== comparison (str1 == str2): " + (str1 == str2));
        System.out.println("== comparison (str1 == str3): " + (str1 == str3));
        System.out.println("equals(): " + str1.equals(str3));
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo(): " + str1.compareTo("World"));
        System.out.println("compareToIgnoreCase(): " + str1.compareToIgnoreCase("HELLO"));
    }

    public static void demonstrateMemoryEfficiency() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("String pool example:");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));

        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        for (int i = 0; i < 50; i++) sb.append("Java");
        System.out.println("Capacity after appending: " + sb.capacity());
    }
}
