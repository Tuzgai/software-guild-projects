/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercises;

/**
 *
 * @author Stuart
 */
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        int orangeCount = 0;
        int appleCount = 0;
        
        
        for (String test : fruit) {
            if (test.equals("Orange")) {
                orangeCount++;
            } else {
                appleCount++;
            }
        }
        
        String [] apples = new String[appleCount];
        String [] oranges = new String[orangeCount];
        
        appleCount = 0;
        orangeCount = 0;
        
        for (String test : fruit) {
            if (test.equals("Orange")) {
                oranges[orangeCount] = test;
                orangeCount++;
            } else {
                apples[appleCount] = test;
                appleCount++;
            }
        }
        
        int sum = orangeCount + appleCount;
        System.out.println("Total fruit: " + sum);
        System.out.println("Total oranges: " + orangeCount);
        System.out.println("Total apples: " + appleCount);
    }
}
