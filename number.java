import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame 
{
 public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) 
           {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");
            System.out.println("You have a maximum of 5 attempts.");

            while (numberOfAttempts < 5 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) 
                {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number correctly.");
                    System.out.println("You took " + numberOfAttempts + " attempts.");
                    totalScore += 10 - numberOfAttempts + 1; // Higher score for fewer attempts
                } 
               else if (userGuess < numberToGuess) 
                {
                    System.out.println("Your guess is too low.");
                } 
               else 
                {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!hasGuessedCorrectly) 
            {
                System.out.println("You've used all 5 attempts. The number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! You played " + totalRounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);

        scanner.close();
    }
}
