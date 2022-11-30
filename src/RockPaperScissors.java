import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
         int win = 0;
         int draw = 0;
         int lose = 0;
         int played = 0;

        Scanner scanner = new Scanner(System.in);

        validNextLine("""
                Welcome to the
                Rock, Paper Scissors Game
                
                WIT Operating Systems
                
                Press Enter to continue.""");

        while (true) {
            String[] rps = {"Rock", "Paper", "Scissors"};
            String computerMove = rps[new Random().nextInt(rps.length)];

            String playerMove;

            while(true) {
                System.out.println("""
                Enter one of the following options: 
                ------------------------------------
                
                R for Rock
                P for Paper
                S for Scissors
                Q for Exit
                
                ------------------------------------
                Make A move:""");
                playerMove = scanner.nextLine();
                playerMove = playerMove.toUpperCase();

                if (playerMove.equals("R") || playerMove.equals("P") || playerMove.equals("S")) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }

            if (playerMove.equals("R")){
                playerMove = "Rock";
            } else if (playerMove.equals("P")){
                playerMove = "Paper";
            } else if (playerMove.equals("S")){
                playerMove = "Scissors";
            }

            System.out.println("The computer picked: " + computerMove + "\nYou picked: " + playerMove + "\n");
            //System.out.println("Computer played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                draw++;
                System.out.println("""

                    ------------------------------------
                    It's a draw!""");
                validNextLine("Press enter to continue");
            } else if (playerWins(playerMove, computerMove)) {
                win++;
                System.out.println("""

                    ------------------------------------
                    Player wins!""");
                validNextLine("Press enter to continue");
            } else {
                lose++;
                System.out.println("""

                    ------------------------------------
                    Computer wins!""");
                validNextLine("Press enter to continue");
            }

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine();
            played++;

            if (!playAgain.equals("y")) {
                System.out.println("""
                Game Over. Thanks for playing Rock, Paper Scissors 
                
                Game Statistics 
                ------------------------------------""");
                System.out.println("Number of games played: " + played);
                System.out.println("Number of games won: " + win);
                System.out.println("Number of games lost: " + lose);
                System.out.println("Number of games tied: " + draw);
                break;
            }
        }
        scanner.close();
    }

    static boolean playerWins(String playerMove, String computerMove) {
        if (playerMove.equals("Rock")) {
            return computerMove.equals("Scissors");
        } else if (playerMove.equals("Paper")) {
            return computerMove.equals("Rock");
        } else {
            return computerMove.equals("Paper");
        }

    }

    public static String validNextLine(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();

    }
}
