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
public class TraditionalFizzBuzz {
    public static void main(String [] args) {
        Scanner scn = new Scanner(System.in);
        int end;
        int counter = 0;
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        end = Integer.parseInt(scn.nextLine());

        for(int i = 0; ;i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
                counter += 2;
            } else if (i % 3 == 0) {
               System.out.println("fizz");
                counter++;
            } else if (i % 5 == 0) {
               System.out.println("buzz");
               counter++;
            } else {
                System.out.println(i);
            }
            
            if (counter >= end) {
                System.out.println("TRADITION!!!!!!");
                break;
            }
        }
    }
}