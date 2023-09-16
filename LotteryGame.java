import java.util.Scanner;
public class LotteryGame {
    public void playLotteryGame(){
        Scanner input = new Scanner(System.in);

//        Generates a random number between 0 and 1 and multiplies it by 100 to get a two-digit number.
        int lotteryNumber = (int)(Math.random()*100);

        System.out.print("Enter your bet in dollars: ");
        int bet = input.nextInt();

        System.out.print("Enter your two-digit guess (0-99): ");
        int guess = input.nextInt();

//        Save lottery digits in two variables
//        96 divided by 10 gives 9 which is the first number
//        96 % 10 gives 6 which is the second number
        int lotteryNumber1= lotteryNumber/10;
        int lotteryNumber2= lotteryNumber%10;

        int guessNumber1=guess/10;
        int guessNumber2=guess%10;

        System.out.println("The lottery number is "+lotteryNumber);

//        Compares the guess with lottery number.
        if(guess==lotteryNumber){
            System.out.println("You've guessed it exactly. Congratulations");
            System.out.println("Your earnings are $"+(bet*10));
        }
        else if ((guessNumber1==lotteryNumber2) && (guessNumber2==lotteryNumber1)){
            System.out.println("You've guessed the numbers correctly but in the wrong order.");
            System.out.println("Your earnings are $"+(bet*3.3));
        }
        else if (((guessNumber1==lotteryNumber1)&&(guessNumber2!=lotteryNumber2))||
                ((guessNumber2==lotteryNumber2)&&(guessNumber1)!=(lotteryNumber1))){
            System.out.println("You've guessed a number in the correct order.");
            System.out.println("Your earnings are $"+(bet*2));
        }
        else if (((guessNumber1==lotteryNumber2)&&(guessNumber2!=lotteryNumber1))||
                (guessNumber2==lotteryNumber1)&&(guessNumber1!=lotteryNumber2)){
            System.out.println("You've guessed a number but in the wrong order. ");
            System.out.println("Your earnings are $"+(bet*0.75));
        }
        else
            System.out.println("Your guess was wrong. Try again.");
    }
}
