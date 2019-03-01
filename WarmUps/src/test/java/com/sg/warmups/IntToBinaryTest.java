package com.sg.warmups;

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
public class IntToBinaryTest {
    IntToBinary instance = new IntToBinary();
    
    public IntToBinaryTest() {
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

    /**
     * Test of intToBinary method, of class IntToBinary.
     */
    @Test
    public void testIntToBinary_0() {
        String expectedValue = "0";
        int n = 0;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
    
    @Test
    public void testIntToBinary_1() {
        String expectedValue = "1";
        int n = 1;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
    
    @Test
    public void testIntToBinary_5() {
        String expectedValue = "101";
        int n = 5;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
    
    
    @Test
    public void testIntToBinary_6() {
        String expectedValue = "110";
        int n = 6;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
    
    @Test 
    public void testIntToBinary_777() {
        String expectedValue = "1100001001";
        int n = 777;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
    
    @Test
    public void testIntToBinary_778() {
        String expectedValue = "1100001010";
        int n = 778;
        assertEquals(expectedValue, instance.intToBinary(n));
    }
}