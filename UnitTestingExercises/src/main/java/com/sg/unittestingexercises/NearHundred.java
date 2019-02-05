package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class NearHundred {
    // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    public boolean nearHundred(int n) {
        return Math.abs(100-n) <= 10;
    }
}
