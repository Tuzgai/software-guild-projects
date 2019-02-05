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
public class NearHundredTest {
    NearHundred instance = new NearHundred();
    public NearHundredTest() {
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
    // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    @Test
    public void test103() {
        assertTrue(instance.nearHundred(103));
    }
    
    @Test
    public void test90() {
        assertTrue(instance.nearHundred(90));
    }
    
    @Test
    public void test89() {
        assertFalse(instance.nearHundred(89));
    }
    
    @Test
    public void test111() {
        assertFalse(instance.nearHundred(111));
    }
    
    @Test
    public void test0() {
        assertFalse(instance.nearHundred(0));
    }
    
}
