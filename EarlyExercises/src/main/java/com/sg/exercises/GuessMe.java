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
public class GuessMe {
    public static void main(String [] args) {
        int choice;
        int correctAnswer = 5;
        Scanner scn = new Scanner(System.in);
        
        do {
            System.out.print("Pick a number: ");
            choice = Integer.parseInt(scn.nextLine());
            if(choice == correctAnswer) {
                System.out.println("You got it!");
                break;
            } else if (choice < correctAnswer) {
                System.out.println("Nice try, go a little higher.");
            } else {
                System.out.println("Nice try, go a little lower.");
            } 
        } while(true);
    }
}