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
public class CoinFlipper {
    public static void main(String[] args) {
        Random rng = new Random();
        boolean toss = rng.nextBoolean();
        
        System.out.println("Ready, Set, Flip....!!");
        System.out.print("You got ");
        
        if(toss){
            System.out.println("HEADS!");
        } else {
            System.out.println("TAILS!");
        }
    }
}
