import java.util.Scanner; 

public class Converter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble(); 
        
        double miles = km / 1.6; 
        
        System.out.println(String.format("The distance in miles is %.2f", miles));
        
        input.close(); 
    }
}
