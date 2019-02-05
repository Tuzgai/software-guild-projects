package com.sg.unittestingexercises;

/**
 *
 * @author Stuart
 */
public class StringSplosion {
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) {
        if(str.length() <= 1) return str;
        
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            s.append(str.substring(0,i+1));
        }
        
        return s.toString();
    }

}
