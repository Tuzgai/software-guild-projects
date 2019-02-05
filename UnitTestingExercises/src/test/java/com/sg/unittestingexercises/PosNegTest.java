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
public class PosNegTest {

    PosNeg instance = new PosNeg();

    public PosNegTest() {
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

    // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    @Test
    public void testPosNegFalse() {
        assertTrue(instance.posNeg(1, -1, false));
    }

    @Test
    public void testNegPosFalse() {
        assertTrue(instance.posNeg(1, -1, false));
    }

    @Test
    public void testNegNegFalse() {
        assertFalse(instance.posNeg(-1, -1, false));
    }

    @Test
    public void testPosPosFalse() {
        assertFalse(instance.posNeg(1, 1, false));
    }

    @Test
    public void testZeroNegFalse() {
        assertTrue(instance.posNeg(0, -1, false));
    }

    @Test
    public void testNegZeroFalse() {
        assertTrue(instance.posNeg(-1, 0, false));
    }

    @Test
    public void testZeroPosFalse() {
        assertFalse(instance.posNeg(0, 1, false));
    }

    @Test
    public void testPosZeroFalse() {
        assertFalse(instance.posNeg(1, 0, false));
    }

    @Test
    public void testPosNegTrue() {
        assertFalse(instance.posNeg(1, -1, true));
    }

    @Test
    public void testNegPosTrue() {
        assertFalse(instance.posNeg(1, -1, true));
    }

    @Test
    public void testNegNegTrue() {
        assertTrue(instance.posNeg(-1, -1, true));
    }

    @Test
    public void testPosPosTrue() {
        assertFalse(instance.posNeg(1, 1, true));
    }

    @Test
    public void testZeroNegTrue() {
        assertFalse(instance.posNeg(0, -1, true));
    }

    @Test
    public void testNegZeroTrue() {
        assertFalse(instance.posNeg(-1, 0, true));
    }

    @Test
    public void testZeroPosTrue() {
        assertFalse(instance.posNeg(0, 1, true));
    }

    @Test
    public void testPosZeroTrue() {
        assertFalse(instance.posNeg(1, 0, true));
    }
}
