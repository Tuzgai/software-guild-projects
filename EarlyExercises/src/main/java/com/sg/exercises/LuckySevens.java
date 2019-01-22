/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class LuckySevens {
    public static void main(String[] args) {
        int currentMoney, mostMoney, roll;
        int rollCount = 0;
        int highestRoll = 0;
        
        Random rng = new Random();
        Scanner scn = new Scanner(System.in);
        
        System.out.print("How much are you willing to bet? ");
        currentMoney = Integer.parseInt(scn.next());
        mostMoney = currentMoney;
        
        do {
            rollCount++;
            roll = rng.nextInt(6)+1 + rng.nextInt(6)+1;
            
            if(roll == 7) {
                currentMoney += 6;
            } else {
                currentMoney -= 1;
            }
            
            if(currentMoney > mostMoney){
                highestRoll = rollCount;
                mostMoney = currentMoney;
            }
        }while(currentMoney > 0);
        
        System.out.println("You went out after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + highestRoll + " rolls with $" + mostMoney + ".");
    }
}
