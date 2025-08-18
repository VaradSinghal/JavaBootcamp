import java.util.Scanner;

class  Break{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		double total = 0.0;
		double userIn = 0.0;
		while(true){
			System.out.println("Enter the number: ");
			userIn = input.nextDouble();
			if (userIn <=0){
				break;
			}
			else{
				total+=userIn;
			}
		
		}
		System.out.println("The sum is " + total);	
	}
} 