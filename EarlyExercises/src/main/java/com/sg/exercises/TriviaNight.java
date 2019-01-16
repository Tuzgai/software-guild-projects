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
public class TriviaNight {
    public static void main(String[] args) {
        int answer1 = 4;
        int answer2 = 2;
        int answer3 = 3;
        int total = 0;
        Scanner scn = new Scanner(System.in);
        
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the lowest level programming language?");
        System.out.println("1) Source Code \t\t 2) Assembly Language");
        System.out.println("3) C# \t\t\t 4) Machine Code");
        System.out.print("YOUR ANSWER: ");
        if (Integer.parseInt(scn.nextLine()) == answer1) {
            total++;
        }
        
        System.out.println("SECOND QUESTION!");
        System.out.println("Website security CAPTCHA forms are descended from the work of?");
        System.out.println("1) Grace Hopper \t\t 2) Alan Turing");
        System.out.println("3) Charles Babbage \t 4) Larry Page");
        System.out.print("YOUR ANSWER: ");
        if (Integer.parseInt(scn.nextLine()) == answer2) {
            total++;
        }
        
        System.out.println("THIRD QUESTION!");
        System.out.println("Which of these sci-fi ships was once slated for a full-size replica in Las Vegas?");
        System.out.println("1) Serenity \t\t 2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprize \t 4) The Millenium Falcon");
        System.out.print("YOUR ANSWER: ");
        if (Integer.parseInt(scn.nextLine()) == answer3) {
            total++;
        }
        
        System.out.println("You got " + total + " correct!");
        if (total == 0) {
            System.out.println("Tough luck - try again next time!");
        }
    }
}