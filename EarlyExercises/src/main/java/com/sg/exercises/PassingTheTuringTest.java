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
public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String name, color, fruit, number;        
        
        System.out.println("Hello there!");
        System.out.print("What's your name? ");
        name = scn.nextLine();
        
        System.out.print("Hi " + name + "! What's your favorite color? ");
        color = scn.nextLine();
        
        System.out.println("Huh, " + color + "? Mine's a nice teal.");
        System.out.print("What's YOUR facorite fruit, " + name + "? ");
        fruit = scn.nextLine();
        
        System.out.println("Really? " + fruit + "? That's wild!");
        System.out.print("Speaking of favorites, what's your favorite number? ");
        number = scn.nextLine();
        
        System.out.println(number + " is a cool number. Mine's 23.");
        System.out.println("Did you know 2 + 3 = 5? 5 is also an important number");
        
        System.out.println("Well, thanks for talking to me, " + name + "!");
    }
}
