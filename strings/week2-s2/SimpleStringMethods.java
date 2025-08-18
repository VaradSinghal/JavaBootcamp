public class SimpleStringMethods{
    public static void main(String[] args){
        String text = "Welcome to Java";

        System.out.println("Length: "+ text.length());
        System.out.println("First 'a' at index: "+ text.indexOf('a'));

        System.out.println("Substring(0,7): "+ text.substring(0,7));
        System.out.println("Uppercase: "+ text.toUpperCase());
        System.out.println("Trimmed: "+ text.trim());

        String other = "welcome to java";
        System.out.println("Equals (ignore case): "+ text.equalsIgnoreCase(other))  ;
    }
}