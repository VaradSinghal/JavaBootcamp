public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        // This line throws NullPointerException
        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Generic Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Uncomment this to see program crash
        // generateException();

        // Handling the exception
        handleException();
    }
}
