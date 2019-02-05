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
public class Makes10Test {
    Makes10 instance = new Makes10();
    public Makes10Test() {
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
    
    // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true
    @Test
    public void testFirstIs10() {
        assertTrue(instance.makes10(10, 9));
    }
    
    @Test
    public void testSecondIs10() {
        assertTrue(instance.makes10(9, 10));
    }
    
    @Test
    public void testNeitherIs10andNot10Sum() {
        assertFalse(instance.makes10(9, 9));
    }
    
    @Test
    public void testSumIs10() {
        assertTrue(instance.makes10(1, 9));
    }
    
    @Test
    public void testSumLessThan10() {
        assertFalse(instance.makes10(1, 1));
    }
    
    @Test
    public void testBoth0() {
        assertFalse(instance.makes10(0, 0));
    }
    
    @Test
    public void testBoth10() {
        assertTrue(instance.makes10(10, 9));
    }
}
