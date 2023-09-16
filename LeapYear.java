import java.util.Scanner;
public class LeapYear {
    public void calculateLeapYear(){
        Scanner input = new Scanner(System.in);

/*
        Asks user to enter a year to check if its leap or not.
        Leap year rules: it must be divisible by 4, it must not be divisible by 100
        OR, it must be divisible by 400
*/
        System.out.print("Please enter a year to check: ");
        int year = input.nextInt();
//        If given year is below zero, prompts user to enter another year.
        while (year < 0){
            System.out.println("The year you entered is not valid.");
            System.out.print("Please enter a year to check: ");
            year = input.nextInt();
        }

        boolean isLeapYear=((year%4==0 && year%100!=0) || (year%400 == 0));

        if (isLeapYear){
            System.out.print(year+" is a leap year.");
        }
        else{
            System.out.print(year+" is NOT a leap year.");
        }
    }
}
