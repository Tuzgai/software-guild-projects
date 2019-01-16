package com.sg.exercises;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stuart
 */
public class StayPositive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int counter = 0;
        System.out.print("What number should I count down from? ");
        for(int i=Integer.parseInt(scn.nextLine()); i > 0; i--){
            System.out.print(i + " ");
            
            if (counter % 10 == 0 && counter > 0) {
                System.out.println("");
            }
            counter++;
        }
    }
}
