package com.sg.unittestingexercises;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
public class StringSplosionTest {
    StringSplosion instance = new StringSplosion();
    public StringSplosionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    @Test
    public void test4Chars() {
        String input = "Code";
        String expectedValue = "CCoCodCode";
        assertEquals(expectedValue, instance.stringSplosion(input));
    }
    
    @Test
    public void test3Chars() {
        String input = "abc";
        String expectedValue = "aababc";
        assertEquals(expectedValue, instance.stringSplosion(input));
    }
    
    @Test
    public void test2Chars() {
        String input = "ab";
        String expectedValue = "aab";
        assertEquals(expectedValue, instance.stringSplosion(input));
    }
    
    @Test
    public void test1Chars() {
        String input = "a";
        String expectedValue = "a";
        assertEquals(expectedValue, instance.stringSplosion(input));
    }
    
    @Test
    public void test0Chars() {
        String input = "";
        String expectedValue = "";
        assertEquals(expectedValue, instance.stringSplosion(input));
    }
    
}
