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
public class CommonEndTest {
    CommonEnd instance = new CommonEnd();
    
    public CommonEndTest() {
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

    // Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    @Test
    public void testSameEnd() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {7,3};
        assertTrue(instance.commonEnd(arr1,arr2));
    }
    
    @Test
    public void testNoMatch() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {7,3,2};
        assertFalse(instance.commonEnd(arr1,arr2));
    }
    
    @Test
    public void testSameStart() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,3};
        assertTrue(instance.commonEnd(arr1,arr2));
    }
    
    @Test
    public void testFirstEmpty() {
        int[] arr1 = {};
        int[] arr2 = {7,3};
        assertFalse(instance.commonEnd(arr1,arr2));
    }
    
    @Test
    public void testSecondEmpty() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {};
        assertFalse(instance.commonEnd(arr1,arr2));
    }
    
    @Test
    public void testBothEmpty() {
        int[] arr1 = {};
        int[] arr2 = {};
        assertTrue(instance.commonEnd(arr1,arr2));
    }
}
