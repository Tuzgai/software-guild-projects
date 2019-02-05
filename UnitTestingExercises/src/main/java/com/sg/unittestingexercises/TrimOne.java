package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class TrimOne {
    // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    public String trimOne(String str) {
        if(str.length() < 2) return "";
        
        return str.substring(1, str.length()-1);
    }
}
