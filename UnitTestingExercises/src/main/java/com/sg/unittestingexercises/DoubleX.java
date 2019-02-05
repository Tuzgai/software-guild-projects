package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class DoubleX {
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        char[] arr = str.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == 'x' && !(arr[i] == 'x')) {
                return false;
            } else if (arr[i-1] == 'x' &&  arr[i] == 'x') {
                return true;
            }
        }
        
        return false;
    }
}
