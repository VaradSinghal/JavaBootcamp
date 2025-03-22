import java.util.Scanner;

public class SalaryCal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the salary: ");
		double salary = input.nextDouble();
		System.out.println("Enter the bonus: ");
		double bonus = input.nextDouble();
		double totalSalary = bonus + salary;
		System.out.println(" The salary is INR " +  salary + " and bonus is INR " + bonus+ " . Hence Total Income is INR " + totalSalary);

	}
}