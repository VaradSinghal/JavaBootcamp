import java.util.Scanner;

	class 	FizzBuzz {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the number: ");
			int number = input.nextInt();
			if (number>=0){
				for(int i = 0; i<=number; i++){
					if (i%3==0 && i%5==0){
						System.out.println("FizzBuzz");
					}
					else if (i%3==0){
						System.out.println("Fizz");
					}
					else if (i%5==0){
						System.out.println("Buzz");
					}
					else{
						System.out.println(i);
					}
				}
			}
			else{
				System.out.println("Not a positive integer");
			}
		}
	}
