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
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        
        for(int i = 0; i < 12; i++) {
            if (firstHalf[i] <= secondHalf[i]) {
                wholeNumbers[i*2] = firstHalf[i];
                wholeNumbers[i*2+1] = secondHalf[i];
            } else {
                wholeNumbers[i*2] = secondHalf[i];
                wholeNumbers[i*2+1] = firstHalf[i];
            }
        }
        
        for(int item : wholeNumbers) {
            System.out.println(item);
        }
    }
}
