package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class FirstHalf {
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    public String firstHalf(String str) {
        if(str.length() == 0 || str.length() % 2 == 1) return "";
        
        return str.substring(0, str.length()/2);
    }

}
