import java.util.Scanner;

class  While{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		while(number >= 1){
			System.out.println(number);
			number--;
			
		}
	}
}