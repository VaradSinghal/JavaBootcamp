import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the principal amount: ");
        int principal = input.nextInt();
        
        System.out.println("Enter the rate of interest: ");
        double rate = input.nextDouble();
        
        System.out.println("Enter the time in years: ");
        int time = input.nextInt();
        
        double simpleInterest = (principal * rate * time) / 100;
        
        System.out.println("The Simple Interest is " + simpleInterest +
                           " for Principal " + principal + ", Rate of Interest " +
                           rate + " and Time " + time);
        
        input.close(); 
    }
}
