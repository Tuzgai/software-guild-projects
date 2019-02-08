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
public class FactorialTest {

    Factorial instance = new Factorial();

    public FactorialTest() {
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
     * Test of factorial method, of class Factorial.
     */
    @Test
    public void test0() {
        int n = 0;
        int expectedValue = 1;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test1() {
        int n = 1;
        int expectedValue = 1;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test2() {
        int n = 2;
        int expectedValue = 2;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test3() {
        int n = 3;
        int expectedValue = 6;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test4() {
        int n = 4;
        int expectedValue = 24;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test7() {
        int n = 7;
        int expectedValue = 5040;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void test12() {
        int n = 12;
        int expectedValue = 479001600;
        assertEquals(expectedValue, instance.factorial(n));
    }

    @Test
    public void testFactorion145() {
        int n = 145;
        assertTrue(instance.isFactorion(n));
    }

    @Test
    public void testFactorion40585() {
        int n = 40585;
        assertTrue(instance.isFactorion(n));
    }

    @Test
    public void testFactorion2() {
        int n = 2;
        assertTrue(instance.isFactorion(n));
    }

    @Test
    public void testFactorion1() {
        int n = 1;
        assertTrue(instance.isFactorion(n));
    }

    @Test
    public void testFactorion0() {
        int n = 0;
        assertFalse(instance.isFactorion(n));
    }

    @Test
    public void testFactorion77() {
        int n = 77;
        assertFalse(instance.isFactorion(n));
    }

    @Test
    public void testFactorion88() {
        int n = 88;
        assertFalse(instance.isFactorion(n));
    }
}
