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
public class IsNumericTest {
    IsNumeric instance = new IsNumeric();
    
    public IsNumericTest() {
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
    public void testIsNumericSimple() {
        assertTrue(instance.isNumeric("1"));
    }
    
    @Test
    public void testIsNumericEmpty() {
        assertFalse(instance.isNumeric(""));
    }
    
    @Test
    public void testIsNumericFalse() {
        assertFalse(instance.isNumeric("Steamed Hams"));
    }
    
    @Test
    public void testIsNumericMixed() {
        assertFalse(instance.isNumeric("1D"));
    }
    
    @Test
    public void testIsNumericDecimal() {
        assertTrue(instance.isNumeric("1.02"));
    }
    
    @Test
    public void testIsNumericLarge() {
        assertTrue(instance.isNumeric("4533254532.32"));
    }  
    
    @Test
    public void testIsNumericDot() {
        assertFalse(instance.isNumeric("."));
    }  
    
    @Test
    public void testIsNumericMoreAfterNumber() {
        assertFalse(instance.isNumeric("1.0F"));
    } 
    
    @Test
    public void testIsNumericMoreBeforeNumber() {
        assertFalse(instance.isNumeric("A1.1"));
    } 
    
    @Test
    public void testIsNumericTwoDota() {
        assertFalse(instance.isNumeric("1.1.1"));
    } 
    
    @Test
    public void testIsNumericTwoNumbers() {
        assertFalse(instance.isNumeric("1.1 2.2"));
    } 
    
    @Test
    public void testIsNumericHangingDot() {
        assertFalse(instance.isNumeric("1."));
    } 
    
    @Test
    public void testIsNumericJustDecimal() {
        assertTrue(instance.isNumeric(".1"));
    } 
}
