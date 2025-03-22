import java.util.Scanner;
class TravelComputation {
   
   public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);

	  System.out.println("Enter the name: ");
      String name = input.nextLine();
      
      System.out.println("Enter the start city: ");
      String fromCity = input.nextLine();
	  System.out.println("Enter the via city: ");
	  String viaCity = input.nextLine();
	  System.out.println("Enter the end city: ");
	  String toCity = input.nextLine();
	
      System.out.println("Enter the distancefromtovia ");
      double distanceFromToVia = input.nextDouble();

      System.out.println("Enter the timetaken in minutes: ");
      int timeFromToVia = input.nextInt();

      System.out.println("Enter the distanceviatofinal ");
      double distanceViaToFinalCity = input.nextDouble();

      System.out.println("Enter the timetaken in minutes: ");	
      int timeViaToFinalCity = input.nextInt();

      
      double totalDistance = distanceFromToVia + distanceViaToFinalCity;

  
      int totalTime = timeFromToVia + timeViaToFinalCity;



      System.out.println("The Total Distance travelled by " + name + " from " + 
                         fromCity + " to " + toCity + " via " + viaCity +
                         " is " + totalDistance + " km and " +
                         "the Total Time taken is " + totalTime + " minutes");
   }
}
