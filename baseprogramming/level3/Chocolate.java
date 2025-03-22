import java.util.Scanner;
class Chocolate {
   
   public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of chocolates: ");
		int numberOfChocolates = input.nextInt();
		System.out.println("Enter number of children: ");
		int numberOfChildren = input.nextInt();
		int chocolates = Math.abs(numberOfChocolates  / numberOfChildren);
		int left = numberOfChocolates%numberOfChildren;
		System.out.println("The number of chocolates each child gets is " + chocolates + " and the number of remaining chocolates are " + left);
		}
	}
		