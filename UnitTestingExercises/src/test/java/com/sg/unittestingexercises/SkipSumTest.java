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
public class SkipSumTest {
    SkipSum instance = new SkipSum();
    
    public SkipSumTest() {
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
    
    // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    @Test
    public void test3_4() {
        int expectedValue = 7;
        assertEquals(instance.skipSum(3,4), expectedValue);
    }
    
    @Test
    public void test9_4() {
        int expectedValue = 20;
        assertEquals(instance.skipSum(9,4), expectedValue);
    }
    
    @Test
    public void test10_11() {
        int expectedValue = 21;
        assertEquals(instance.skipSum(10,11), expectedValue);
    }
    
    @Test
    public void test0_0() {
        int expectedValue = 0;
        assertEquals(instance.skipSum(0,0), expectedValue);
    }
    
    @Test
    public void test5_5() {
        int expectedValue = 20;
        assertEquals(instance.skipSum(5,5), expectedValue);
    }
    
    @Test
    public void test9_10() {
        int expectedValue = 20;
        assertEquals(instance.skipSum(9,10), expectedValue);
    }
}
