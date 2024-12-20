import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int DieSides = 6;
        int userPoints = 0;
        int computerPoints = 0;
        String userRoll = "y";
        int rounds = 1;

        Die userDie1 = new Die(DieSides);
        Die userDie2 = new Die(DieSides);
        Die computerDie1 = new Die(DieSides);
        Die computerDie2 = new Die(DieSides);

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Let's play Blackjack but with dice!");
        while (true) {
            System.out.println("How many rounds do you want to play?");
            if (scan.hasNextInt()) {
                rounds = scan.nextInt();
                if (rounds > 0) {
                    break;  // Valid input, exit the loop
                } else {
                    System.out.println("Please enter only positive number of rounds.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number on the numpad for the number of rounds.");
                System.out.println();
                scan.next();  // Clear the invalid input
            }
        }

        scan.nextLine();

        for (int i = 1; i <= rounds; i++)
        {
            System.out.println("Round " + i + " is staring...");
            Thread.sleep(4000);
            userPoints = 0;
            computerPoints = 0;

            do
            {
                System.out.println();
                System.out.println("rolling your die...");
                Thread.sleep(3000);
                userDie1.roll();
                System.out.println();
                System.out.println("you rolled " + userDie1.getValue() + " on your first die");
                System.out.println("you rolled " + userDie2.getValue() + " on your second die");
                userPoints = userDie1.getValue() + userDie2.getValue() + userPoints;
                System.out.println("you have a total of " + userPoints);

                if (userPoints > 21) {
                    break;
                }

                System.out.println();
                System.out.println("rolling the computer's die...");
                Thread.sleep(3000);
                System.out.println("Computer is done rolling!");
                computerDie1.roll();
                computerDie2.roll();
                computerPoints = computerDie1.getValue() + computerDie2.getValue() + computerPoints;
                System.out.println();

                if (computerPoints > 21) {
                    break;
                }

                boolean validInput = false;
                while (!validInput) {
                    System.out.println("Do you want to roll again? Enter y/n");
                    userRoll = scan.nextLine().trim().toLowerCase();  // Normalize input to lowercase and trim spaces
                    if (userRoll.equals("y") || userRoll.equals("n")) {
                        validInput = true;  // Valid input, exit the loop
                    } else {
                        System.out.println();
                        System.out.println("Invalid input. Please enter 'y' to roll again or 'n' to stop.");
                        System.out.println();
                    }
                }
            } while (userRoll.equalsIgnoreCase("y"));

            System.out.println("The computers total is " + computerPoints);

            if (userPoints > 21) {
                System.out.println("You went over 21! You lose!");
                System.out.println();
            } else if (computerPoints > 21) {
                System.out.println("The computer went over 21! You win!");
                System.out.println();
            } else if (userPoints > computerPoints) {
                System.out.println("You win!");
                System.out.println();
            } else if (userPoints < computerPoints) {
                System.out.println("You lose!");
                System.out.println();
            } else {
                System.out.println("Push! It's a tie!");
                System.out.println();
            }


        }

    }
}