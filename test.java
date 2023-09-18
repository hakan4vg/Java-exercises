import java.util.Scanner;
import GuessingGame.*;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int selector;

        BMICalculator bmiCalculator = new BMICalculator();
        TaxCalculator taxCalculator = new TaxCalculator();
        LeapYear leapYear = new LeapYear();
        LotteryGame lotteryGame = new LotteryGame();

        while (true) {
            selector = 0; // Reset selector at the beginning of each iteration

            // Asks the user to select which code they want to try.
            while (selector <= 0 || selector > 5) {
                System.out.print("""
                        \n1-BMI Calculator
                        2-Tax Calculator(WIP)
                        3-Leap Year Calculator
                        4-Lottery Game
                        5-Lottery Game With Account Selection(WIP)
                        -1 to exit
                        Select which code you want to try:""");
                selector = input.nextInt();

                if (selector == -1) {
                    break; // Exit the inner loop if -1 is entered
                }
            }

            if (selector == -1) {
                System.out.println("Exiting the program.");
                break; // Exit the outer loop if -1 is entered
            }

            System.out.println();

            switch (selector) {
                case 1:
                    bmiCalculator.calculateBMI();
                    break;
                case 2:
                    taxCalculator.calculateTaxes();
                    break;
                case 3:
                    leapYear.calculateLeapYear();
                    break;
                case 4:
                    lotteryGame.playLotteryGame();
                    break;
                case 5:
                    System.out.print("Enter your username: ");
                    String username = input.next();
                    System.out.print("Enter your password: ");
                    String password = input.next();
                    UserDatabase userDatabase = new UserDatabase();
                    User user = userDatabase.getUserByUsername(username);

                    if (user != null && user.getPassword().equals(password)) {
                        System.out.println("Welcome, " + username + "! Your account balance is: $" + user.getCoinBalance());
                        System.out.print("Enter your bet: ");
                        double bet = input.nextDouble();
                        System.out.print("Enter your guess: ");
                        int guess = input.nextInt();

                        GuessingGame guessingGame = new GuessingGame(userDatabase);
                        guessingGame.playGame(username, password, bet, guess);
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
