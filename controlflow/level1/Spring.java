import java.util.Scanner;

class  Spring{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the month number: ");
		int month = input.nextInt();
		System.out.println("Enter the day: ");
		int day = input.nextInt();
		if (month >=3 && month <=6){
			if ( month == 3 && day<20 || month == 6 && day>20){
				System.out.println("Not a Spring Season");
			}
			else{
			System.out.println("Its Spring Season");
			}
		}
		else{
			System.out.println("Not a Spring Season");
			}
	}
}	