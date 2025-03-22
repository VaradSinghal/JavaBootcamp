import java.util.Scanner; 

public class Height {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
      
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        
       
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);  
        double inches = totalInches % 12; 

      
        System.out.println(String.format(
            "Your Height in cm is %.2f while in feet is %d and inches is %.2f",
            heightCm, feet, inches
        ));
        
        input.close(); 
    }
}
