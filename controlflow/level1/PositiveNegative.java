import java.util.Scanner;

class PositiveNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		if (number == 0){
			System.out.println("Zero");
			}
		else{
			if (number>0){
				System.out.println("Positive");
			}
			else{
				System.out.println("Negative");
				}
		}
	}
}