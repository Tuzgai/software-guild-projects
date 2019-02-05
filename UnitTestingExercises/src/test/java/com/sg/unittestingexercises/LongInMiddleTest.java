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
public class LongInMiddleTest {
    LongInMiddle instance = new LongInMiddle();
    public LongInMiddleTest() {
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
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    @Test
    public void testhiHello() {
        String outer = "hi";
        String inner = "Hello";
        String expectedResult = "hiHellohi";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
    
    @Test
    public void testhelloHi() {
        String outer = "Hello";
        String inner = "hi";
        String expectedResult = "hiHellohi";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
    
    @Test
    public void testaaab() {
        String outer = "aaa";
        String inner = "b";
        String expectedResult = "baaab";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
    
    @Test
    public void testbaaa() {
        String outer = "b";
        String inner = "aaa";
        String expectedResult = "baaab";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
    
    @Test
    public void testfirstEmpty() {
        String outer = "";
        String inner = "bb";
        String expectedResult = "bb";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
    
    @Test
    public void testSecondEmpty() {
        String outer = "bb";
        String inner = "";
        String expectedResult = "bb";
        
        assertEquals(expectedResult, instance.longInMiddle(outer, inner));
    }
}
