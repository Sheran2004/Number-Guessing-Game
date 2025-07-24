import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxAttempts = 7;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int target = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔢 I have picked a number between 1 and 100.");
            System.out.println("💡 You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("👉 Enter your guess: ");
                int guess;
                try {
                    guess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("⚠️ Please enter a valid number!");
                    sc.next(); // clear invalid input
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempt(s)!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < target) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }

                System.out.println("🕓 Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The correct number was: " + target);
            }

            roundsPlayed++;
            System.out.println("\n📊 Score: " + roundsWon + " win(s) out of " + roundsPlayed + " round(s).");

            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.startsWith("y");
        }

        System.out.println("\n🏁 Game Over! Thanks for playing. Final Score: " + roundsWon + "/" + roundsPlayed);
        sc.close();
    }
}
