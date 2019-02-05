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
public class DoubleXTest {
    DoubleX instance = new DoubleX();
    public DoubleXTest() {
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
    
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    @Test
    public void testBaseCase() {
        assertTrue(instance.doubleX("axxbb"));
    }
    
    @Test
    public void testFirstXIsNotDouble() {
        assertFalse(instance.doubleX("axaxxax"));
    }
    
    @Test
    public void testManyXsInARow() {
        assertTrue(instance.doubleX("xxxxx"));
    }
    
    @Test
    public void testNoXs() {
        assertFalse(instance.doubleX("aabb"));
    }
    
    @Test
    public void test1X() {
        assertFalse(instance.doubleX("x"));
    }
    
    @Test
    public void testEmpty() {
        assertFalse(instance.doubleX(""));
    }
    
    @Test
    public void testDoubleXStart() {
        assertTrue(instance.doubleX("xxbb"));
    }
    
    @Test
    public void testDoubleXEnd() {
        assertTrue(instance.doubleX("abbxx"));
    }
    
    @Test
    public void testJustDoubleX() {
        assertTrue(instance.doubleX("xx"));
    }
}
