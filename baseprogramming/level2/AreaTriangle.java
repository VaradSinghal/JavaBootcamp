import java.util.Scanner;
class AreaTriangle {
   
   public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		System.out.println("Enter height: ");
		double height = input.nextDouble();
		System.out.println("Enter base: ");
		double base = input.nextDouble();
		double area= (height*base)/2;
		System.out.println("The area of triangle is " + area);
   
   }
}

