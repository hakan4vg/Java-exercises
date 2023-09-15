
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Prompt user to decide which system they want to use
        String sis = "";
        while (!sis.equals("Metric") && !sis.equals("Imperial")) {
            System.out.print("Specify which system you want to use (Metric/Imperial): ");
            sis = input.next();
        }
        double weightInMetric=0;
        double heightInMetric=0;
        if (sis.equals("Metric")) {
            //Prompt user to input their weight in kilograms
            System.out.print("Enter your weight in kilograms: ");
            weightInMetric = input.nextDouble();

            //Prompt user to input their height in centimeters
            System.out.print("Enter your height in meters: ");
            heightInMetric = input.nextDouble();
            while (heightInMetric>10){
                System.out.print("Given height is not in meters: ");
                heightInMetric = input.nextDouble();
            }

        }
        else if (sis.equals("Imperial")){
            //Prompt user to input their weight in pounds
            System.out.print("Enter your weight in pounds: ");
            double weight = input.nextDouble();

            //Prompt user to input their height in inches
            System.out.print("Enter your height in inches: ");
            double height = input.nextDouble();

            weightInMetric = weight*0.45359237;
            heightInMetric = height*0.0254;
        }

        double bmi = weightInMetric/(heightInMetric*heightInMetric);

        System.out.printf("Based on given parameters, BMI is: %f\n", bmi);
        if(bmi<18.5)
            System.out.println("Underweight");
        else if(bmi<25)
            System.out.println("Healthy");
        else if(bmi<30)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }

}
