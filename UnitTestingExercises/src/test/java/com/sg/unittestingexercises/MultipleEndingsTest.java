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
public class MultipleEndingsTest {
    MultipleEndings instance = new MultipleEndings();
    public MultipleEndingsTest() {
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
    
    // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    @Test
    public void testHello() {
        assertEquals("lololo", instance.multipleEndings("Hello"));
    }
    
    @Test
    public void testab() {
        assertEquals("ababab", instance.multipleEndings("ab"));
    }
    
    @Test
    public void testHi() {
        assertEquals("HiHiHi", instance.multipleEndings("Hi"));
    }
    
    @Test
    public void testOneChar() {
        assertEquals("aaa", instance.multipleEndings("a"));
    }
    
    @Test
    public void testEmpty() {
        assertEquals("", instance.multipleEndings(""));
    }
    
}
