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
public class HiddenNuts {
    public static void main(String[] args) {
        String[] hidingSpots = new String[100];
        
        for(int i = 0; i < hidingSpots.length; i++){
            hidingSpots[i] = "";
        }
        
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nuts";
        System.out.print("The nut has been hidden ... ");
        
        for (int i = 0; i < hidingSpots.length; i++) {
            if(hidingSpots[i].equals("Nuts")) {
                System.out.println("in hiding spot #" + i);
            }
        }
    }
}
