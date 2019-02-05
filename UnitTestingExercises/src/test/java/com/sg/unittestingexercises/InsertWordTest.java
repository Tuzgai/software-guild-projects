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
public class InsertWordTest {
    InsertWord instance = new InsertWord();
    public InsertWordTest() {
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
    // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    @Test
    public void testAngleBracesYay() {
        assertEquals("<<Yay>>", instance.insertWord("<<>>", "Yay"));
    }
    
    @Test
    public void testAngleBracesWooHoo() {
        assertEquals("<<WooHoo>>", instance.insertWord("<<>>", "WooHoo"));
    }
    
    @Test
    public void testSquareBracesWord() {
        assertEquals("[[word]]", instance.insertWord("[[]]", "word"));
    }
    
    @Test
    public void testAngleBracesEmpty() {
        assertEquals("<<>>", instance.insertWord("<<>>", ""));
    }
    
    
}
