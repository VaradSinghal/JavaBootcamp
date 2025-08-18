import java.util.Scanner;

	class 	Tallest {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Amar Age and Height in cm: ");
			int amarAge = input.nextInt();
			int amarHeight = input.nextInt();
			System.out.println("Enter Akbar Age and Height in cm: ");
			int akbarAge = input.nextInt();
			int akbarHeight = input.nextInt();
			System.out.println("Enter Anthony Age and Height in cm: ");
			int anthonyAge = input.nextInt();
			int anthonyHeight = input.nextInt();
			if (akbarAge <amarAge && akbarAge< anthonyAge){
				System.out.println("Akbar is youngest");
			}
			else if (amarAge<anthonyAge){
				System.out.println("Amar is youngest");
			}
			else{
				System.out.println("Anthony is youngest");
			}
			if (akbarHeight >amarHeight && akbarHeight> anthonyHeight){
				System.out.println("Akbar is tallest");
			}
			else if (amarHeight > anthonyHeight){
				System.out.println("Amar is Tallest");
			}
			else{
				System.out.println("Anthony is Tallest");
			}
		}
	}