import java.util.Scanner;
class ArrayIn{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int[] arr = new int[10];
	for (int i=0;i<10;i++){
		System.out.println("Enter student age: ");
		arr[i] = input.nextInt();
	}
	for (int i=0;i<10;i++){
		if (arr[i] >=18){
		System.out.println("Eligible for voting with age " + arr[i]);
		}
		else{
		System.out.println(" Not Eligible for voting with age " + arr[i]);
		}
		
	}
}
}