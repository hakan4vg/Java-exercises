import java.util.Scanner;
import GuessingGame.*;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int selector = 0;
        BMICalculator bmiCalculator = new BMICalculator();
        TaxCalculator taxCalculator = new TaxCalculator();
        LeapYear leapYear = new LeapYear();
        LotteryGame lotteryGame = new LotteryGame();

        while (true) { // Infinite loop
            // Asks the user to select which code they want to try.
            while (selector <= 0 || selector > 5) {
                System.out.print("""
                        \n1-BMI Calculator
                        2-Tax Calculator(WIP)
                        3-Leap Year Calculator
                        4-Lottery Game
                        5-Lottery Game With Account Selection(WIP)
                        Type 'q' to exit
                        Select which code you want to try:""");
                String choice = input.next();

                if (choice.equals("q")) {
                    System.out.println("Exiting the program.");
                    return; // Exit the program
                }

                try {
                    selector = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    System.out.println("Invalid input. Please enter a valid option or 'q' to exit.");
                }
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

                    if (user == null) {
                        // If the user is not found, create a new user
                        System.out.println("Creating a new account for " + username);
                        user = new User(username, password);
                        userDatabase.addUser(user);
                    } else if (!user.getPassword().equals(password)) {
                        System.out.println("Invalid password. Please try again.");
                        break;
                    }

                    System.out.println("Welcome, " + username + "! Your account balance is: $" + user.getCoinBalance());
                    System.out.print("Enter your bet: ");
                    double bet = input.nextDouble();
                    System.out.print("Enter your guess: ");
                    int guess = input.nextInt();

                    GuessingGame guessingGame = new GuessingGame(userDatabase);
                    guessingGame.playGame(username, password, bet, guess);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
            selector = 0; // Reset selector to allow the user to select again
        }
    }
}
