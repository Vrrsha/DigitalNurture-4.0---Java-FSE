import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;

        System.out.println("Guess a number between 1 and 100:");

        while (true) {
            guess = sc.nextInt();
            if (guess < numberToGuess)
                System.out.println("Too low! Try again:");
            else if (guess > numberToGuess)
                System.out.println("Too high! Try again:");
            else {
                System.out.println("Correct! The number was " + numberToGuess);
                break;
            }
        }
    }
}
