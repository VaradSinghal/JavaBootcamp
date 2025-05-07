import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        return choices[new Random().nextInt(3)];
    }

    public static String determineWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Scissors") && computer.equals("Paper")) ||
            (user.equals("Paper") && computer.equals("Rock"))) {
            return "User";
        }
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of games: ");
        int games = sc.nextInt();
        sc.nextLine(); // Consume newline

        int userWins = 0, computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();
            String computerChoice = getComputerChoice();

            String winner = determineWinner(userChoice, computerChoice);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Result: " + winner);
        }

        System.out.println("\n--- Game Results ---");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.printf("User Win Percentage: %.2f%%\n", (userWins * 100.0) / games);
        System.out.printf("Computer Win Percentage: %.2f%%\n", (computerWins * 100.0) / games);

        sc.close();
    }
}
