import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        while (true) {
            // Generate a random number
            Random random = new Random();
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            // Initialize variables
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Start the game
            while (attempts < maxAttempts) {
                String guessString = JOptionPane.showInputDialog("Guess the number between "
                        + minRange + " and " + maxRange + ":");
                int guess = Integer.parseInt(guessString);

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number "
                            + randomNumber + " correctly.");
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "The number is higher than " + guess + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "The number is lower than " + guess + ".");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Game over! The number was " + randomNumber + ".");
            }

            int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again",
                    JOptionPane.YES_NO_OPTION);

            if (playAgain == JOptionPane.NO_OPTION) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Your score: " + score);
        JOptionPane.showMessageDialog(null, "Thank you for playing Guess the Number!");
    }
}
