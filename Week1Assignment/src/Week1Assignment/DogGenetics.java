package Week1Assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Stuart Wilson
 */
public class DogGenetics {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rng = new Random();
        String name;
        String [] breeds = { "St. Bernard", "Chihuahua", "Dramatic Red Nosed Asian Pug", "Common Cur", "King Doberman"};
        int [] scores = new int[5];
        int pointsLeft = 100;
        int random;
        
        System.out.print("What is your dog's name? ");
        name = scn.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        
        for (int i = 0; i < 5; i++) {
            random = rng.nextInt(pointsLeft) + 1;
            pointsLeft -= random;
            scores[i] = random;
        }
        
        // Make sure to use up any remaining points to hit 100% total
        scores[4] += pointsLeft;
        
        System.out.println("\n" + name + " is: \n");
        for (int i = 0; i < 5; i++) {
            System.out.println(scores[i] + "%\t" + breeds[i]);
        }
        
        System.out.println("\nWow, that's QUITE the dog!");
    }
}
