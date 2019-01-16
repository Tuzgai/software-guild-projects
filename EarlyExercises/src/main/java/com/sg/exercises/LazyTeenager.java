package com.sg.exercises;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stuart
 */
public class LazyTeenager {
    public static void main(String[] args) {
        int attempts = 0;
        double chance = 0.05;
        double check;
        Random rng = new Random();
        
        do {
            attempts++;
            System.out.println("Clean your room!! (x" + attempts + ")");
            check = rng.nextDouble();
            
            if (check < chance) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            
            if (attempts == 15) {
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
            }
        } while(attempts <= 14);
    }
}
