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
public class TrimOneTest {
    TrimOne instance = new TrimOne();
    public TrimOneTest() {
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
    
    // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    @Test
    public void testHello() {
        String expectedResult = "ell";
        String input = "Hello";
        
        assertEquals(expectedResult, instance.trimOne(input));
    }
    
    @Test
    public void testjava() {
        String expectedResult = "av";
        String input = "java";
        
        assertEquals(expectedResult, instance.trimOne(input));
    }
    
    @Test
    public void testcoding() {
        String expectedResult = "odin";
        String input = "coding";
        
        assertEquals(expectedResult, instance.trimOne(input));
    }
    
    @Test
    public void testTwoChars() {
        String expectedResult = "";
        String input = "ll";
        
        assertEquals(expectedResult, instance.trimOne(input));
    }
    
    @Test
    public void testOneChar() {
        String expectedResult = "";
        String input = "e";
        
        assertEquals(expectedResult, instance.trimOne(input));
    }
    
}
