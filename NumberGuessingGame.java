import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            int minRange = 1;
            int maxRange = 100;
            int secretNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            int maxAttempts = 5;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts && secretNumber != attempts) {
                System.out.println("Sorry, you've run out of attempts. The number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (true/false): ");
            playAgain = scanner.nextBoolean();
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
