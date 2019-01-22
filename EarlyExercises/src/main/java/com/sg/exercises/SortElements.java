/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercises;

import java.util.Random;

/**
 *
 * @author Stuart
 */
public class SortElements {
    public static void main(String[] args) {
        String [] arr = MakeElementArray(200);
        int bCount = 0;
        int lCount = 0;
        int hCount = 0;
        
        for(String item : arr) {
            if(item.substring(0,1).equals("B")){
                bCount++;
            } else if (item.substring(0,1).equals("L")) {
                lCount++;
            } else if (item.substring(0,1).equals("H")) {
                hCount++;
            }
        }
        
        String [] h = new String[hCount];
        String [] l = new String[lCount];
        String [] b = new String[bCount];
        bCount = 0;
        lCount = 0;
        hCount = 0;
        
        for(String item : arr) {
            if(item.substring(0,1).equals("B")){
                b[bCount] = item;
                bCount++;
            } else if (item.substring(0,1).equals("L")) {
                l[lCount] = item;
                lCount++;
            } else if (item.substring(0,1).equals("H")) {
                h[hCount] = item;
                hCount++;
            }
        }
        
        for(String item : b){
            System.out.println(item);
        }
        
        for(String item : l) {
            System.out.println(item);
        }
        
        for(String item : h) {
            System.out.println(item);
        }
    }
    
    public static String[] MakeElementArray(int size) {
        String[] result = new String[size];
        Random r = new Random();
        for(int i = 0; i < result.length; i++)
        {
            int value = r.nextInt(5);
            switch (value)
            {
                case 0:
                    result[i] = "Hydrogen";
                    break;
                case 1:
                    result[i] = "Helium";
                    break;
                case 2:
                    result[i] = "Lithium";
                    break;
                case 3:
                    result[i] = "Berylium";
                    break;
                case 4:
                    result[i] = "Boron";
                    break;
                default:                        
                    break;
            }

        }
    return result;
    }
}
    
