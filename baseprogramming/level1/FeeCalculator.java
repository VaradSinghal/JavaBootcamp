import java.util.Scanner;

public class FeeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter the student fee (INR): ");
        double fee = input.nextDouble();
        
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();
        
       
        double discount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discount;
        
        System.out.println(String.format(
            "The discount amount is INR %.2f and final discounted fee is INR %.2f",
            discount, finalFee
        ));
        
        input.close(); 
    }
}
