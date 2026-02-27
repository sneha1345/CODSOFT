import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        String choice;

        System.out.println("--------Number Guessing Game Started--------");

        do {

            int number = rand.nextInt(100) + 1;  
            int attempts = 5;
            boolean win = false;

            System.out.println("\nGuess a number between 1 and 100...!!!!");
            System.out.println("You have 5 attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                

                if (guess == number) {
                    System.out.println("Correct! You guessed it...!!!");
                    win = true;
                    score++;
                    break;
                }
                else if (guess > number) {
                    System.out.println("Too high....!!");
                }
                else {
                    System.out.println("Too low..!!!");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!win) {
                System.out.println("You lost..!! The correct number was: " + number);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Do you want to play again....??? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\nGame Over....!!!!");
        System.out.println("~~~~ Total Rounds Won: ~~~~  : " + score);

        sc.close();
    }
}