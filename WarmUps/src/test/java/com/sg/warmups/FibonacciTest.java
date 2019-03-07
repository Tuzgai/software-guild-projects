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
public class FibonacciTest {
    Fibonacci instance = new Fibonacci();
    public FibonacciTest() {
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
     * Test of fib method, of class Fibonacci.
     */
    @Test
    public void testFib5() {
        assertEquals(2, instance.fib(3));
    }
    
    @Test
    public void testPrimeNot() {
        assertFalse(instance.isPrime(8));
    }
    
    @Test
    public void testPrimeYes() {
        assertTrue(instance.isPrime(13));
    }
    
        @Test
    public void testPrime2() {
        assertTrue(instance.isPrime(2));
    }
    
}
