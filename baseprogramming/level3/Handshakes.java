import java.util.Scanner;

class Handshakes {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the number of students: ");
	int numberOfStudents = input.nextInt();
	int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
	System.out.println("Number of possible outcomes are "+ handshakes);
	
	}
}