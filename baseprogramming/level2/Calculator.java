import java.util.Scanner;
class Calculator {
   
   public static void main(String[] args){
		double number1,number2;
		Scanner input= new Scanner(System.in);
		System.out.println("Enter first number: ");
		number1= input.nextDouble();
		System.out.println("Enter second number: ");
		number2= input.nextDouble();
		double sum = number1+ number2;
		double subtract = number1-number2;
		double product = number1*number2;
		double quotient = number1/number2;
		System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1+ " and " + number2 +" is "+sum+ ", "+ subtract+ ", "+ product + ", and "+ quotient);
		input.close();
   
   }
}