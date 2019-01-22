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
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad = new String[12];
        int fruitCount = 0;
        int appleCount = 0;
        int orangeCount = 0;
        int berryCount = 0;
        
        for (int i = 0; i < fruit.length; i++) {
            if(fruit[i].contains("berry")) {
                fruitSalad[fruitCount] = fruit[i];
                fruitCount++;
                berryCount++;
            }
        }
        
        for (int i = 0; i < fruit.length; i++) {
            if (fruitCount >= 12) {
                break;
            }
            if (fruit[i].contains("Apple") && appleCount < 3) {
                fruitSalad[fruitCount] = fruit[i];
                fruitCount++;
                appleCount++;
            } else if (fruit[i].contains("Apple") && appleCount >= 3) {
                continue;
            } else if (fruit[i].contains("Orange") && orangeCount < 2) {
                fruitSalad[fruitCount] = fruit[i];
                fruitCount++;
                orangeCount++;
            } else if (fruit[i].contains("Orange") && orangeCount >= 2) {
                continue;
            } else if (fruit[i].contains("Tomato")) {
                continue;
            } else {
                fruitSalad[fruitCount] = fruit[i];
            }
        }
        
        System.out.println("Total fruits: " + fruitCount);
        System.out.println("Berry count: " + berryCount);
        System.out.println("Apple count: " + appleCount);
        System.out.println("Orange count: " + orangeCount);
    }
}
