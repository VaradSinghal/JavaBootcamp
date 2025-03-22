import java.util.Scanner;

	class NumberTable {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the number: ");
			int number = input.nextInt();
			for (int i=6; i<=9;i++){
				System.out.println( number + " * " + i + " = " + (number*i));
			}
		}
	}