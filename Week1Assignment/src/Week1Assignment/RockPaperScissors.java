package Week1Assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Stuart Wilson
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        final int CPU_WIN = 0;
        final int PLAYER_WIN = 1;
        final int DRAW = 2;
        Scanner scn = new Scanner(System.in);
        Random rng = new Random();
        int rounds, playerMove, cpuMove, result, playerWins, cpuWins, draws;
        String cpuMoveString = new String();
        // Main program loop, break out when user chooses to quit
        while (true) {
            // Reset for a new round
            playerWins = 0;
            cpuWins = 0;
            draws = 0;

            System.out.print("How many rounds would you like to play? (1-10) : ");
            rounds = Integer.parseInt(scn.nextLine());

            if (rounds <= 0 || rounds > 10) {
                System.out.println("Error: invalid number of rounds. Exiting...");
                break;
            }

            while (rounds > 0) {
                System.out.print("Choose your move! 1 = Rock, 2 = Paper, 3 = Scissors : ");
                playerMove = Integer.parseInt(scn.nextLine());
                cpuMove = rng.nextInt(3) + 1;

                switch (cpuMove) {
                    case ROCK:
                        cpuMoveString = "ROCK";
                        break;
                    case PAPER:
                        cpuMoveString = "PAPER";
                        break;
                    case SCISSORS:
                        cpuMoveString = "SCISSORS";
                        break;
                }

                System.out.println("\nThe CPU chose... " + cpuMoveString + "!\n");

                if (playerMove == cpuMove) {
                    result =  DRAW;
                } else if (playerMove == PAPER && cpuMove == ROCK) {
                    result = PLAYER_WIN;
                } else if (playerMove == ROCK && cpuMove == SCISSORS) {
                    result = PLAYER_WIN;
                } else if (playerMove == SCISSORS && cpuMove == PAPER) {
                    result = PLAYER_WIN;
                } else {
                    // If it wasn't a draw and the player didn't win, the CPU won
                    result =  CPU_WIN;
                }

                switch (result) {
                    case CPU_WIN:
                        cpuWins++;
                        break;
                    case PLAYER_WIN:
                        playerWins++;
                        break;
                    case DRAW:
                        draws++;
                        break;
                }

                System.out.println("CURRENT STANDINGS");
                System.out.println("Player victories: " + playerWins);
                System.out.println("CPU victories: " + cpuWins);
                System.out.println("Draws: " + draws + "\n");
                rounds--;
            }

            System.out.print("Would you like to play again? (Y/N) ");
            // Quit if they indicate anything other than yes
            if (!scn.nextLine().toLowerCase().contains("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }
}
