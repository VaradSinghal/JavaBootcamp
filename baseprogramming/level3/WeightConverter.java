import java.util.Scanner;

class WeightConverter {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter weight in pounds: ");
	double weight = input.nextDouble();
	double weightInKg = 2.2*weight;
	System.out.println("The weight of the person in pound is " + weight + " and in kg is " + weightInKg);
	}
}
