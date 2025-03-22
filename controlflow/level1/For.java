import java.util.Scanner;

class  For{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		for (int i=number;i>=1;i--){
			System.out.println(i);
		}
	}
}