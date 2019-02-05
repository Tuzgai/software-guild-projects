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
public class SumTest {
    Sum instance = new Sum();
    public SumTest() {
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

    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    @Test
    public void test1_2_3() {
        int[] arr = {1,2,3};
        assertEquals(instance.sum(arr), 6);
    }
    
    @Test
    public void test5_11_2() {
        int[] arr = {5,11,2};
        assertEquals(instance.sum(arr), 18);
    }
    
    @Test
    public void test7_0_0() {
        int[] arr = {7,0,0};
        assertEquals(instance.sum(arr), 7);
    }
    
    @Test
    public void testSingleElement() {
        int[] arr = {1};
        assertEquals(instance.sum(arr), 1);
    }
    
    @Test
    public void testEmpty() {
        int[] arr = {};
        assertEquals(instance.sum(arr), 0);
    }
    
}
