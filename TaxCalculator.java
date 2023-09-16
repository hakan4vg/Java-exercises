import java.util.Scanner;
public class TaxCalculator {
    public void calculateTaxes(){
        Scanner input = new Scanner(System.in);

//        Gives information about filing status
        System.out.print("""
                1-Single Filer
                2-Married Jointly or Qualifying Widow(er)
                3-Married Separately
                4-Head of Household
                """);
//        Prompts user to enter a filing status according to numbers above
        int status;
        System.out.print("Please enter filing status: ");
        status = input.nextInt();
//        If selected number is incorrect, asks user to enter a valid number
        while (status <= 0 || status>4){
            System.out.print("Incorrect number, please select between"+
                    " 1 and 4:");
            status = input.nextInt();
        }

//        Prompts user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();
        double tax;

        if (status==1){
            if (income <= 8350)
                tax=income * 0.10;
            else if (income<=33950)
                tax=8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <=  82250)
                tax=8350*0.10 + (33950-8350)*0.15 + (income-33950)*0.25;
            else if (income <= 171550)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (income-82250)*0.28;
            else if (income <= 372950)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (income-171550)*0.33;
            else
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (372950-171550)*0.33 + (income-372950)*0.35;
        }
//        I don't know the tax rates in US and don't have access to internet rn. Will update later.
        else if (status==2){
            if (income <= 8350)
                tax=income * 0.10;
            else if (income<=33950)
                tax=8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <=  82250)
                tax=8350*0.10 + (33950-8350)*0.15 + (income-33950)*0.25;
            else if (income <= 171550)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (income-82250)*0.28;
            else if (income <= 372950)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (income-171550)*0.33;
            else
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (372950-171550)*0.33 + (income-372950)*0.35;
        }
        else if (status==3){
            if (income <= 8350)
                tax=income * 0.10;
            else if (income<=33950)
                tax=8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <=  82250)
                tax=8350*0.10 + (33950-8350)*0.15 + (income-33950)*0.25;
            else if (income <= 171550)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (income-82250)*0.28;
            else if (income <= 372950)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (income-171550)*0.33;
            else
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (372950-171550)*0.33 + (income-372950)*0.35;
        }
        else {
            if (income <= 8350)
                tax=income * 0.10;
            else if (income<=33950)
                tax=8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <=  82250)
                tax=8350*0.10 + (33950-8350)*0.15 + (income-33950)*0.25;
            else if (income <= 171550)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (income-82250)*0.28;
            else if (income <= 372950)
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (income-171550)*0.33;
            else
                tax=8350*0.10 + (33950-8350)*0.15 + (82250-33950)*0.25 + (171550-82250)*0.28 + (372950-171550)*0.33 + (income-372950)*0.35;
        }
        System.out.printf("Tax is %f.\n", tax);
    }
}
