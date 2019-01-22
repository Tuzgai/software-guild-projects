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
public class PrimeFactorize {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Which number should I factorize? ");
        int n = Integer.parseInt(scn.nextLine());
        
        // initialize
        boolean [] arr = new boolean[n];
        for(int i=0; i<arr.length; i++) {
            arr[i] = true;
        }
        
        // sieve of eratosthenes
        for (int i=2; i<arr.length; i++){
            if(arr[i]) {
                for(int j = i*i; j < n; j += i){
                    arr[j] = false;
                }
            }
            
            if(n % i != 0) {
                arr[i] = false;
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                System.out.println("Prime: " + i);   
            }
        }
    }
}
