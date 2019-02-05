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
public class FirstHalfTest {
    FirstHalf instance = new FirstHalf();
    public FirstHalfTest() {
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

    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    @Test
    public void testHooHoo() {
        assertEquals("Hoo", instance.firstHalf("HooHoo"));
    }
    
    @Test
    public void testHelloThere() {
        assertEquals("Hello", instance.firstHalf("HelloThere"));
    }
    
    @Test
    public void testabcdef() {
        assertEquals("abc", instance.firstHalf("abcdef"));
    }
    
    @Test
    public void testEmpty() {
        assertEquals("", instance.firstHalf(""));
    }
    
    @Test
    public void testab() {
        assertEquals("a", instance.firstHalf("ab"));
    }
}
