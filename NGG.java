
import java.util.Random;
import java.util.Scanner;

public class NGG {
    public static void main(String[] args) {
        guessTheNumber();
    }

    private static void guessTheNumber() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("------------------------------------");

        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            
            Random random = new Random();
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nNew Round! Try to guess the number between 1 and 100.");

            while (true) {
                try {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    scanner.nextLine(); 

                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        roundsWon++;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    if (attempts == 10) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); 
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            playAgain = playAgainResponse.startsWith("y");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Thanks for playing!");

        
        scanner.close();
    }
}
