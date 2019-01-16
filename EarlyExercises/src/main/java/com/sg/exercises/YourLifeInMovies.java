/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercises;

import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class YourLifeInMovies {
    public static void main(String [] args) {
        String name;
        int dob;
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Let's play a game! What's your name? ");
        name = scn.nextLine();
        System.out.print("Ok, " + name + ", when were you born? ");
        dob = Integer.parseInt(scn.nextLine());
        
        System.out.println("Well " + name + "...");
        
        if (dob < 2005) {
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        }
        if (dob < 1995) { 
            System.out.println("Did you know that the first Harry Potter came out 15 years ago?");
        }   
        if (dob < 1985) {
            System.out.println("Did you know that Space Jam came out not last decade, but the one before THAT?");
        }
        if (dob < 1975) {
            System.out.println("Did you know that the original Jurassic Park release is closer to the date of the first lunar landing than it is to today?");
        }
        if (dob < 1965) {
            System.out.println("Did you know that MASH TV has been around for almost half a century?");
        }
        if(dob >= 2005) {
            System.out.println("Wow, you're young!");
        }
    }
}
