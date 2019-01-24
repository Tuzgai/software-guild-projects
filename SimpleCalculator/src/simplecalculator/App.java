package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class App {
    public static void main(String[] args) {
        String operator;
        double operand1, operand2;
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Hello! Let's do some math.");
        while(true){
            System.out.print("Choose an operator (+,-,*,/, anything else to exit): ");
            operator = scn.nextLine();
            
            if(!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
                System.out.println("Thanks for calculating with us!");
                break;
            }
            
            System.out.print("X: ");
            operand1 = Double.parseDouble(scn.nextLine());
            
            System.out.print("Y: ");
            operand2 = Double.parseDouble(scn.nextLine());
            
            switch (operator) {
                case "+":
                    System.out.println(operand1 + " + " + operand2 + " = " + SimpleCalculator.add(operand1,operand2));
                    break;
                case "-":
                    System.out.println(operand1 + " - " + operand2 + " = " + SimpleCalculator.subtract(operand1,operand2));
                    break;
                case "*":
                    System.out.println(operand1 + " * " + operand2 + " = " + SimpleCalculator.multiply(operand1,operand2));
                    break;
                case "/":
                    System.out.println(operand1 + " / " + operand2 + " = " + SimpleCalculator.divide(operand1,operand2));
                    break;
                default:
                    break;
            }
        }
    }
}
