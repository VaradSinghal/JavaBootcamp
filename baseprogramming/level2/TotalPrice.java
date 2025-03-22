import java.util.Scanner;

public class TotalPrice{
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the unit price: ");
		double unitPrice= input.nextDouble();
		System.out.println("Enter the quantity: ");
		int quantity= input.nextInt();
		double totalPrice = unitPrice*quantity;
		System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity +  "and unit price is INR " + unitPrice);

		
	}
}