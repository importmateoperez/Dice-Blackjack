import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int DieSides = 6;
        int userPoints = 0;
        int computerPoints = 0;
        String userRoll = "y";

        Die userDie1 = new Die(DieSides);
        Die userDie2 = new Die(DieSides);
        Die computerDie1 = new Die(DieSides);
        Die computerDie2 = new Die(DieSides);

        Scanner scan = new Scanner(System.in);
        System.out.println("Lets play BlackJack but with dice!");
        System.out.println("Press enter to play");
        userRoll = scan.nextLine();

        do
        {
            System.out.println();
            System.out.println("rolling your die!");
            userDie1.roll();
            System.out.println("you rolled " + userDie1.getValue() + " on your first die");
            System.out.println("you rolled " + userDie2.getValue() + " on your second die");
            userPoints = userDie1.getValue() + userDie2.getValue() + userPoints;
            System.out.println("you have a total of " + userPoints);

            System.out.println();
            System.out.println("rolling the computer's die!");
            computerDie1.roll();
            computerDie2.roll();
            computerPoints = computerDie1.getValue() + computerDie2.getValue() + computerPoints;
            System.out.println();

            if (userPoints > 21)
            {
                System.out.println("You went over 21!");
                break;
            }
            if (computerPoints > 21) {
                System.out.println("The computer when over 21!");
                break;
            }

            System.out.println("Want to roll again? Enter y/n");
            userRoll = scan.nextLine();

            if (!userRoll.equalsIgnoreCase("y"))
            {
                break;
            }

        } while (userRoll.equalsIgnoreCase("y"));

        System.out.println("Your total is " + userPoints);
        System.out.println("The computers total is " + computerPoints);

        if (userPoints > computerPoints && computerPoints < 21 || computerPoints > 21)
        {
            System.out.println("you win!");
        } else if (userPoints == computerPoints) {
            System.out.println("Push!");
        } else {
            System.out.println("You lose!");
        }

    }
}