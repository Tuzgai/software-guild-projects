package Week1Assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class DogGeneticsMathy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rng = new Random();
        String name;
        String [] breeds = { "St. Bernard", "Chihuahua", "Dramatic Red Nosed Asian Pug", "Common Cur", "King Doberman"};
        int [] scores = new int[5];
        int random;
        double sum = 0;
        
        System.out.print("What is your dog's name? ");
        name = scn.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        
        
        // Populate our random distribution
        for(int i=0; i<5; i++){
            scores[i] = rng.nextInt(100);
            sum += scores[i];
        }
        
        // Normalize to a percentage
        // TODO: rounding is still broken
        for(int i=0; i<5; i++) {
            scores[i] = (int) Math.round(100 * (scores[i] / sum));
        }
        
        sum = 0;
        System.out.println("\n" + name + " is: \n");
        for (int i = 0; i < 5; i++) {
            sum += scores[i];
            System.out.println(scores[i] + "%\t" + breeds[i]);
        }
        
        System.out.println("\nWow, that's QUITE the dog! Sum:" + sum);
    }
}
