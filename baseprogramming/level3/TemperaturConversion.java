import java.util.Scanner;

public class TemperaturConversion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature: ");
		double celcius = input.nextDouble();
		double farenheitResult= (celcius * 9/5) + 32;
		System.out.println("The "+ celcius+ " celsius is " + farenheitResult + " fahrenheit");
	}

}