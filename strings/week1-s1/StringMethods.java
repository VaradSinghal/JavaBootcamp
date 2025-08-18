import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name (first and last name): ");
        String fullName = scanner.nextLine();

     
        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

  
        System.out.print("Enter a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        String firstName = "";
        String lastName = "";
        if (fullName.contains(" ")) {
            int spaceIndex = fullName.indexOf(" ");
            firstName = fullName.substring(0, spaceIndex);
            lastName = fullName.substring(spaceIndex + 1);
        } else {
            firstName = fullName;
            lastName = "(No last name provided)";
        }

        int charCount = experience.replace(" ", "").length();

    
        String langUpper = favLang.toUpperCase();


        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Programming Language : " + langUpper);
        System.out.println("Your experience sentence: " + experience);
        System.out.println("Total characters in your sentence (excluding spaces): " + charCount);

        scanner.close();

    }
}
