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
public class RotateLeftTest {
    RotateLeft instance = new RotateLeft();
    public RotateLeftTest() {
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
    // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    @Test
    public void test1_2_3() {
       int[] test = {1,2,3};
       int[] expectedResult = {2,3,1};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
    
    @Test
    public void test5_11_9() {
       int[] test = {5,11,9};
       int[] expectedResult = {11,9,5};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
    
    @Test
    public void test7_0_0() {
       int[] test = {7,0,0};
       int[] expectedResult = {0,0,7};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
    
    @Test
    public void test1_2() {
       int[] test = {1,2};
       int[] expectedResult = {2,1};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
    
    @Test
    public void test1() {
       int[] test = {1};
       int[] expectedResult = {1};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
    
    @Test
    public void testEmpty() {
       int[] test = {};
       int[] expectedResult = {};
       assertArrayEquals(expectedResult, instance.rotateLeft(test));
    }
}
