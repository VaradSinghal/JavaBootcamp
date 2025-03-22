import java.util.Scanner;

class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the  number: ");
		int number = input.nextInt();
		int factorial =1;
		if (number>0){
			for(int i = number;i>=1;i--){
			factorial*=i;
			
			}
		}
		System.out.println("The factorial is " + factorial);
	}
}