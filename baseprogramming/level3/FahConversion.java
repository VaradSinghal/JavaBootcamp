import java.util.Scanner;

public class FahConversion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature: ");
		double fahrenheit = input.nextDouble();
		double celsiusResult= (fahrenheit - 32) * 5/9;
		System.out.println("The "+ fahrenheit+ " fahrenheit is " + celsiusResult + " celsius");
	}

}