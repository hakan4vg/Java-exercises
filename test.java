import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int selector=0;
        BMICalculator bmiCalculator = new BMICalculator();
        TaxCalculator taxCalculator = new TaxCalculator();
        LeapYear leapYear = new LeapYear();
        LotteryGame lotteryGame = new LotteryGame();

//        Asks user to select which code they want to try.
        while (selector <=0 || selector>4){
            System.out.print("""
                    \n1-BMI Calculator
                    2-Tax Calculator(WIP)
                    3-Leap Year Calculator
                    4-Lottery Game
                    Select which code you want to try:""");
            selector = input.nextInt();}
        System.out.println();

//            Don't forget to change after additions;
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
        }
    }
}