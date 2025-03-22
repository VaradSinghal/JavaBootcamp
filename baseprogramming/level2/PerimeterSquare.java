import java.util.Scanner;
class PerimeterSquare {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the side: ");
		double side = input.nextDouble();
		double perimeter = 4*side;
		System.out.println("The length of the side is " + side + " whose perimeter is "+ perimeter);
	}

}