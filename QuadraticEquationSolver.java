import java.util.Scanner;

public class QuadraticEquationSolver{
    public void solveQuadratic(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        String inputLine = input.nextLine();
        String[] parts = inputLine.split("[,\\s]+");
        while (parts.length!=3){
            System.out.print("Please enter 3 coefficients: ");
            inputLine=input.nextLine();
            parts = inputLine.split("[,\\s]+");
        }
        double[] coefficients = new double[3];

        try{
            for (int i=0; i<3; i++){
                coefficients[i]=Double.parseDouble(parts[i]);

            }
        }catch (NumberFormatException e){
            System.out.println("Invalid input, please try again.\n");
        }
        System.out.printf("Your quadratic equation is (%fx²)+(%fx)+(%f)\n",coefficients[0],coefficients[1],coefficients[2]);

        double discriminant = (coefficients[1]*coefficients[1])-4*(coefficients[0]*coefficients[2]);

        if (discriminant>0){
            double root1 = (-(coefficients[1])+Math.sqrt(discriminant)/(2*coefficients[0]));
            double root2 = (-(coefficients[1])- Math.sqrt(discriminant)/(2*coefficients[0]));
            System.out.printf("Your quadratic equation has two real roots: x1=%f, x2=%f\n",root1,root2);
        } else if (discriminant == 0) {
            double root = -coefficients[1]/(2*coefficients[0]);
            System.out.printf("Your quadratic equation has a single real root: x=%f\n",root);
        }
        else {
            double realPart = (-coefficients[1]) / (2 * coefficients[0]);
            double imaginaryPart = Math.sqrt(-discriminant)/(2*coefficients[0]);
            System.out.println("Your quadratic equation has two complex roots: ");
            System.out.println("x1 = "+realPart+" + "+imaginaryPart+"i");
            System.out.println("x2 = "+realPart+" - "+imaginaryPart+"i");
        }



    }
}