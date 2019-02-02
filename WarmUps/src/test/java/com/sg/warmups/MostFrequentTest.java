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
public class MostFrequentTest {
    MostFrequent instance = new MostFrequent();
    
    public MostFrequentTest() {
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

    @org.junit.Test
    public void testNull() {
        int[] arr = {};
        assertEquals(0, instance.findMostFrequent(arr));
    }
    
    @org.junit.Test
    public void testAllSame() {
        int [] arr = {1,2,3};
        assertEquals(1, instance.findMostFrequent(arr));
    }
    
    @org.junit.Test
    public void testNextToEachOther() {
        int [] arr = {1,1,2,3};
        assertEquals(1, instance.findMostFrequent(arr));
    }
    
    @org.junit.Test
    public void testSeparated() {
        int [] arr = {1,2,3,1};
        assertEquals(1, instance.findMostFrequent(arr));
    }
    
    
    @org.junit.Test
    public void testHigherThanTwo() {
        int [] arr = {1,1,4,2,2,4,3,4};
        assertEquals(4, instance.findMostFrequent(arr));
    }
    
    @org.junit.Test
    public void testOneElement() {
        int [] arr = {4};
        assertEquals(4, instance.findMostFrequent(arr));
    }
}
