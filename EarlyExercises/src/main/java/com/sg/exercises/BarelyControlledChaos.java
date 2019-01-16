/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercises;

import java.util.Random;

/**
 *
 * @author Stuart
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {
        String color = randomColor();
        String animal = randomAnimal();
        String colorAgain = randomColor();
        int weight = randomIntFromRange(5, 200);
        int distance = randomIntFromRange(10, 20);
        int number = randomIntFromRange(10000, 20000);
        int time = randomIntFromRange(2, 6);
        
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    }
    
    public static String randomColor() {
        String option1 = "red";
        String option2 = "light red";
        String option3 = "dark red";
        String option4 = "orange red";
        String option5 = "blood red";
        
        Random rng = new Random();
        
        int choice = rng.nextInt(5);
        
        switch(choice){
            case 1:
                return option1;
            case 2:
                return option2;
            case 3:
                return option3;
            case 4:
                return option4;
            case 5:
                return option5;
        }
        return "Something broke";
    }
    
    public static String randomAnimal() {
        String option1 = "red panda";
        String option2 = "fox";
        String option3 = "cardinal";
        String option4 = "red snapper";
        String option5 = "parrot";
        
        Random rng = new Random();
        
        int choice = rng.nextInt(5);
        
        switch(choice){
            case 1:
                return option1;
            case 2:
                return option2;
            case 3:
                return option3;
            case 4:
                return option4;
            case 5:
                return option5;
        }
        return "Something broke";
    }
    
    public static int randomIntFromRange(int min, int max) {
        Random rng = new Random();
        
        return rng.nextInt(max-1) + min;
    }
}
