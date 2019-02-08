package com.sg.warmups;

/**
 *
 * @author Stuart
 */
public class Factorial {
    public int factorialRecursive (int n) {
        if(n <= 1) return 1;
       
        return n * factorialRecursive(n-1);
    }
    
    public int factorial (int n) {
        if(n <= 1) return 1;
        
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        
        return total;
    }
    
    public boolean isFactorion(int n) {
        int[] digits = Integer.toString(n).chars().map((c) -> Character.getNumericValue(c)).toArray();
        int total = 0;
        
        for(int i = 0; i < digits.length; i++) {
            total += factorial(digits[i]);
        }
        
        return total == n;
    }
    
    public boolean isFactorionOptimized(int n) {
        return (n == 1 || n == 2 || n == 145 || n == 40585); // O(1) execution
    }
}
