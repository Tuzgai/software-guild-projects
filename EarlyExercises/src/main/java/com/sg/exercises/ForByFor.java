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
public class ForByFor {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    // first consider the corners
                    if((i == 0 || i == 2) && (j == 0 || j == 2)) {
                        System.out.print("*");
                    // top and bottom
                    } else if ((i == 0 || i == 2)) {
                        System.out.print("$");
                    // center
                    } else if (j == 1) {
                        System.out.print("#");
                    // and all we have left is the sides
                    } else {
                        System.out.print("@");
                    }
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
