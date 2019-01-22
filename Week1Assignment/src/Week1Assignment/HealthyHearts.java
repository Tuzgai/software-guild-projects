package Week1Assignment;

import java.util.Scanner;

/**
 *
 * @author Stuart Wilson
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int age, maxHeartRate, lowHeartRate;
        double highHeartRate;
        
        System.out.print("What is your age? ");
        age = Integer.parseInt(scn.nextLine());
        
        maxHeartRate = 220 - age;
        lowHeartRate = maxHeartRate / 2;
        highHeartRate = maxHeartRate * 0.85;
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + lowHeartRate + " - " + (int) highHeartRate + " beats per minute.");
    }
}
