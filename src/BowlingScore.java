import java.util.Scanner;

/**
 *
 * Name: Attal Mumin
 * Date: [Date]
 * Purpose: Simulates a bowling game between two players over 10 frames.
 */
public class BowlingScore {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            // Get player names
            System.out.print("Enter name for Player 1: ");
            String player1Name = scanner.nextLine();
            System.out.print("Enter name for Player 2: ");
            String player2Name = scanner.nextLine();

            // Initialize players
            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);

            // Play 10 frames
            for (int frame = 1; frame <= 10; frame++) {
                System.out.println("Frame " + frame + ":");

                // Player 1 turn
                int player1Score = getTurnScores(player1, player1Name);
                player1.updateScore(player1Score);

                // Player 2 turn
                int player2Score = getTurnScores(player2, player2Name);
                player2.updateScore(player2Score);

                System.out.println("Scores after Frame " + frame + ":");
                System.out.println(player1Name + ": " + player1.getScore());
                System.out.println(player2Name + ": " + player2.getScore());
                System.out.println();
            }

            // Display final scores
            System.out.println("Final Scores:");
            System.out.println(player1Name + ": " + player1.getScore());
            System.out.println(player2Name + ": " + player2.getScore());

            // Ask if the user wants to play again
            System.out.print("Do you want to play another game? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();

            // Check user response
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        scanner.close();
    }

    /**
     * Handles scoring logic for one player's turn in a frame.
     *
     * @param player The player whose turn it is
     * @param playerName The name of the player
     * @return The score for the player's turn
     */
    private static int getTurnScores(Player player, String playerName) {
        int score = 0;

        // First roll
        int roll1 = getRoll(playerName);
        score += roll1;

        if (roll1 == 10) {
            // Strike
            System.out.println(playerName + " rolled a strike!");

            // Bonus rolls for the 10th frame
            if (player.getFrame() == 10) {
                score += getRoll(playerName); // Second roll in the 10th frame
                score += getRoll(playerName); // Third roll in the 10th frame
            }
        } else {
            // Second roll
            int roll2 = getRoll(playerName);
            score += roll2;

            if (roll1 + roll2 == 10) {
                // Spare
                System.out.println(playerName + " rolled a spare!");

                // Bonus roll for the 10th frame
                if (player.getFrame() == 10) {
                    score += getRoll(playerName); // Third roll in the 10th frame
                }
            }
        }

        // Advance to the next frame
        player.nextFrame();
        return score;
    }

    /**
     * Retrieves a valid roll score from user input.
     *
     * @param playerName The name of the player
     * @return The roll score entered by the user
     */
    private static int getRoll(String playerName) {
        Scanner scanner = new Scanner(System.in);
        int roll = -1;
        while (roll < 0 || roll > 10) {
            System.out.print(playerName + ", enter roll score (0-10): ");
            roll = scanner.nextInt();
            if (roll < 0 || roll > 10) {
                System.out.println("Invalid input. Please enter a score between 0 and 10.");
            }
        }
        return roll;
    }
}

