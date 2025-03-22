import java.util.Scanner;
class ArrayStud{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int[] arr = new int[5];
	for (int i=0;i<5;i++){
		System.out.println("Enter number: ");
		arr[i] = input.nextInt();
		}
	for (int i=0;i<5;i++){
		if(arr[i] >0){
			if (arr[i] %2 ==0){
				System.out.println( arr[i] +" is even and positive");
			} else {
				System.out.println( arr[i] +" is odd and positive");
			}
		
		} else if ( arr[i] == 0){
			System.out.println( arr[i] +" is zero");
		} else {
			System.out.println( arr[i] +" is negative");
		}
	}	
	if (arr[0]>arr[4]){
		System.out.println( "First element is greater than last");
	} else if (arr[0] == arr[4]){
		System.out.println( "First element and last element are equal");
	} else {
		System.out.println( "First element is smaller than last");

	}
	}
}