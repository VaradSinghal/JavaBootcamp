import java.util.Scanner; 
public class GradeCalculator { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter marks for Physics: "); 
        int physics = sc.nextInt(); 
        System.out.print("Enter marks for Chemistry: "); 
        int chemistry = sc.nextInt(); 
        System.out.print("Enter marks for Math: "); 
        int math = sc.nextInt(); 
        sc.close(); 
        double avg = (physics + chemistry + math) / 3.0; 
         String grade = (avg >= 80) ? "A" : 
                       (avg >= 70) ? "B" : 
                       (avg >= 60) ? "C" : 
                       (avg >= 50) ? "D" : 
                       (avg >= 40) ? "E" : "R"; 
        System.out.println("\nAverage Marks: " + avg + "%"); 
        System.out.println("Grade: " + grade); 
    } 
} 
