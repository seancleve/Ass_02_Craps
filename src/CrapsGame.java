import java.util.Random;
import java.util.Scanner;

public class CrapsGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlaying = true;

        System.out.println("Welcome to the Craps Game!");

        while (continuePlaying)
        {
            int dice1 = rollDie(random);
            int dice2 = rollDie(random);
            int sum = dice1 + dice2;

            System.out.println("Initial roll: Die 1 = " + dice1 + ", Die 2 = " + dice2 + ", Sum = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You crapped out. You lose.");
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("Natural! You win!");
            }
            else
            {
                int point = sum;
                System.out.println("Point is now: " + point);

                boolean continueRolling = true;
                while (continueRolling)
                {
                    dice1 = rollDie(random);
                    dice2 = rollDie(random);
                    sum = dice1 + dice2;

                    System.out.println("Trying for point: Die 1 = " + dice1 + ", Die 2 = " + dice2 + ", Sum = " + sum);

                    if (sum == point)
                    {
                        System.out.println("Made point! You win!");
                        continueRolling = false;
                    } else if (sum == 7)
                    {
                        System.out.println("Got a seven! You lose.");
                        continueRolling = false;
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("y"))
            {
                continuePlaying = false;
            }
        }

        System.out.println("Thanks for playing!");

    }
    private static int rollDie(Random random) {
        return random.nextInt(6) + 1; // Generates a number between 1 and 6

    }
}
