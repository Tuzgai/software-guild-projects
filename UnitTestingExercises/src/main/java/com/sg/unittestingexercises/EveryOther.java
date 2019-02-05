package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class EveryOther {
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public String everyOther(String str) {
        char[] arr = str.toCharArray();
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i < arr.length; i += 2) {
            s.append(arr[i]);
        }
        
        return s.toString();
    }

}
