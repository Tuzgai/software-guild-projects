package com.sg.warmups;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;


/**
 *
 * @author Stuart
 */
public class IsNumeric {
    public boolean isNumeric(String s) { 
        return Pattern.matches("^[0-9]+\\.?[0-9]*$", s);
    }
    
    public boolean isNumericLoop(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'));
        char[] arr = s.toCharArray();
        if(arr.length == 0) {
            return false;
        }
                
        int dotCounter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(arr[i])) {
                return false;
            }
            
            if(arr[i] == '.') {
                dotCounter++;
            }
        }
        
        if(dotCounter > 1 || arr[arr.length-1] == '.') {
            return false;
        }
        
        return true;
    }
}
