import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3; // You can adjust the number of rounds as desired
        int totalAttemptsPerRound = 5; // You can adjust the attempts allowed per round as desired

        int totalScore = 0;

        System.out.println("Welcome to Guess the Number Game!");

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + " of " + totalRounds);
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");

            while (attempts < totalAttemptsPerRound) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    int roundScore = totalAttemptsPerRound - attempts + 1; // Assigning points based on attempts
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }

                if (attempts == totalAttemptsPerRound) {
                    System.out.println("Sorry, you've used all your attempts. The number was: " + targetNumber);
                }
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }
}
