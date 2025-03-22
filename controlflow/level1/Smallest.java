import java.util.Scanner;

class Smallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int number1 = input.nextInt();
		System.out.println("Enter the second number: ");
		int number2 = input.nextInt();
		System.out.println("Enter the third number: ");
		int number3 = input.nextInt();
		if (number1 < number2 && number1 < number3){
			System.out.println("Is the first number the smallest? - " + true);
			}
		else{
			System.out.println("Is the first number the smallest? - " + false);
		}
	}
}