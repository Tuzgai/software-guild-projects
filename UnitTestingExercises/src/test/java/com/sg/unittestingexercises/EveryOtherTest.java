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
public class EveryOtherTest {
    EveryOther instance = new EveryOther();
    public EveryOtherTest() {
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
    
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    @Test
    public void testHello() {
        assertEquals("Hlo", instance.everyOther("Hello"));
    }
    
    @Test
    public void testHi() {
        assertEquals("H", instance.everyOther("Hi"));
    }
    @Test
    public void testHeeololeo() {
        assertEquals("Hello", instance.everyOther("Heeololeo"));
    }
    
    @Test
    public void testOneCharacter() {
        assertEquals("H", instance.everyOther("H"));
    }
    
    @Test
    public void testEmpty() {
        assertEquals("", instance.everyOther(""));
    }
}
