package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class InterestCalculator {

    public static void main(String[] args) {
        final int DAILY = 1;
        final int MONTHLY = 2;
        final int QUARTERLY = 3;
        final int ANNUALLY = 4;
        double interestRate, principal, balance, interestEarned;
        int yearsInFund, compoundRate, numberOfCompounds;
        String compoundRateString;
        Scanner scn = new Scanner(System.in);

        // Get input
        System.out.println("Hello! Let's do some interest calculations.");
        System.out.print("Interest Rate: ");
        interestRate = Double.parseDouble(scn.nextLine());
        System.out.print("Initial Principal: ");
        principal = Double.parseDouble(scn.nextLine());
        balance = principal;
        System.out.print("Years in fund: ");
        yearsInFund = Integer.parseInt(scn.nextLine());
        System.out.print("Compounding frequency (1-Daily, 2-Monthly, 3-Quarterly, 4-Anually: ");
        compoundRate = Integer.parseInt(scn.nextLine());

        switch (yearsInFund) {
            case DAILY:
                compoundRateString = "daily";
                numberOfCompounds = 365;
                break;
            case MONTHLY:
                compoundRateString = "monthly";
                numberOfCompounds = 12;
                break;
            case QUARTERLY:
                compoundRateString = "quarterly";
                numberOfCompounds = 4;
                break;
            default:
                compoundRateString = "annually";
                numberOfCompounds = 1;
        }

        for (int i = 0; i < yearsInFund; i++) {
            for (int j = 0; j < numberOfCompounds; j++) {
                balance *= 1 + (interestRate / 100);
            }
            interestEarned = balance - principal;
            System.out.print("Year: " + i + "\tPrincipal: $" + String.format("%.2f", principal));
            System.out.println("\tInterest earned: $" + String.format("%.2f", interestEarned) + "\tEnd of Year Balance: $" + String.format("%.2f", balance));
            principal = balance;
        }

    }

}
