import java.util.Scanner;

	class Salary {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the salary: ");
			double salary = input.nextDouble();
			System.out.println("Enter years of service: ");
			int yearsOfService = input.nextInt();
			if (yearsOfService>5){
				double bonus = (5*salary)/100;
				System.out.println("Bonus salary is " + (salary+bonus));
			}
			else{
			System.out.println("Not applicable");
			}
		}
	}