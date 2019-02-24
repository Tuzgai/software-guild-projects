package com.sg.warmups;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
public class RotateArrayTest {

    RotateArray instance = new RotateArray();

    public RotateArrayTest() {
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

    @Test
    public void testRotateArray() {
        int[] arr = {1, 2, 3, 4};
        int rot = 2;
        int[] expectedValue = {3, 4, 1, 2};
        Assert.assertArrayEquals(expectedValue, instance.rotateArray(arr, rot));
    }

    @Test
    public void testRotateArrayFull() {
        int[] arr = {1, 2, 3, 4};
        int rot = 4;
        int[] expectedValue = {1, 2, 3, 4};
        Assert.assertArrayEquals(expectedValue, instance.rotateArray(arr, rot));
    }

    @Test
    public void testRotateArrayNoRot() {
        int[] arr = {1, 2, 3, 4};
        int rot = 0;
        int[] expectedValue = {1, 2, 3, 4};
        Assert.assertArrayEquals(expectedValue, instance.rotateArray(arr, rot));
    }

    @Test
    public void testRotateArray6Elements() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int rot = 2;
        int[] expectedValue = {5, 6, 1, 2, 3, 4};
        Assert.assertArrayEquals(expectedValue, instance.rotateArray(arr, rot));
    }
    
    @Test
    public void testRotateArray6ElementsRotGreaterThanLength() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int rot = 8;
        int[] expectedValue = {5, 6, 1, 2, 3, 4};
        Assert.assertArrayEquals(expectedValue, instance.rotateArray(arr, rot));
    }
}
