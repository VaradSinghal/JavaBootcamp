import java.util.Scanner;

class  UserIn{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		double total = 0.0;
		double userin=1.0;
		while (userin!=0){
			System.out.println("Enter double numbers: ");
			userin=input.nextDouble();
			total+=userin;
		}
		System.out.println("The sum is " + total);
	}	
}