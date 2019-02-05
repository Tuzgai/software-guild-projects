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
public class CaughtSpeedingTest {
    CaughtSpeeding instance = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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

    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    @Test
    public void test60False() {
        int expectedValue = 0;
        int speed = 60;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test65False() {
        int expectedValue = 1;
        int speed = 65;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test65True() {
        int expectedValue = 0;
        int speed = 65;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test0False() {
        int expectedValue = 0;
        int speed = 0;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test0True() {
        int expectedValue = 0;
        int speed = 60;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test80True() {
        int expectedValue = 1;
        int speed = 80;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test80False() {
        int expectedValue = 1;
        int speed = 80;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
    @Test
    public void test81False() {
        int expectedValue = 2;
        int speed = 81;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
        @Test
    public void test81True() {
        int expectedValue = 1;
        int speed = 81;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
        @Test
    public void test85False() {
        int expectedValue = 2;
        int speed = 85;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
        @Test
    public void test85True() {
        int expectedValue = 1;
        int speed = 85;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
    
        @Test
    public void test86False() {
        int expectedValue = 2;
        int speed = 86;
        boolean bday = false;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
        @Test
    public void test86True() {
        int expectedValue = 2;
        int speed = 86;
        boolean bday = true;
        assertEquals(expectedValue, instance.caughtSpeeding(speed, bday));
    }
}
