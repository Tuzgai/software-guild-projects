package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class MultipleEndings {
    // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    public String multipleEndings(String str) {
        if(str.length() <= 2) return str + str + str;
        String out = str.substring(str.length()-2, str.length());
        return out + out + out;
    }

}
