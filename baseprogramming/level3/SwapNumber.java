import java.util.Scanner;

public class SwapNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int num1 = input.nextInt();
		System.out.println("Enter the second number: ");
		int num2= input.nextInt();
		int temp;
		temp = num1;
		num1 = num2;
		num2=temp;
		System.out.println("The sawpped numbers are " + num1 + " and " + num2 );
	}
}