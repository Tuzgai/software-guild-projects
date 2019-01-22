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
public class Multiply {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x, y;
        
        System.out.print("X = ");
        x = Integer.parseInt(scn.nextLine());
        
        System.out.print("Y = ");
        y = Integer.parseInt(scn.nextLine());
        
        System.out.println("X * Y = " + multiply(x,y));
        
        System.out.println("X / Y = " + divide(x,y));
    }
    
    public static int multiply(int x, int y) {
        int total = 0;
        for(int i = 0; i < y ; i++) {
            total += x;
        }
        return total;
    }
    
    public static double divide(int x, int y) {
        // Set up, make sure we're not using negative numbers
        int sign = 1;
        int precision = 20;
        if(x < 0 && y < 0) {
            x *= -1;
            y *= -1;
        } else if (x < 0) {
            x *= -1;
            sign = -1;
        } else if (y < 0) {
            y *= -1;
            sign = -1;
        }
        
        return sign * divideRecursively(x, y, 0);
    }

    /** 
     * @param x - numerator
     * @param y - denominator
     * @param precisionCount - default 0, when to break out of recursive loop early
     * @return 
     * 
     */
    public static double divideRecursively(int x, int y, int precisionCount) {
        int count = 0;
        int precision = 20;
        precisionCount++;
        boolean flag = false;
        
        // borrowing, but now tail-recursive
        if (x < y) {
            flag = true;
        }
        
        while (x >= y){
            count++;
            x -= y;
        }
        
        // stop if there's no more division to do or if we're at the desired precision
        if((x == 0) || (precisionCount == precision)){
            return 0;
        } 
        
        if(flag == true) {
            count = 0;
        }
        
        return count + 0.1 * divideRecursively(x * 10, y, precisionCount);
    }
}
