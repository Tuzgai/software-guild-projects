package com.sg.wordgame.dao;

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
public class WordGameDaoFileImplTest {
    WordGameDaoFileImpl instance = new WordGameDaoFileImpl();
    
    public WordGameDaoFileImplTest() {
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
     * Test of getWord method, of class WordGameDaoFileImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetWord() throws Exception {
        System.out.print("getWord: ");
        String expResult = "";
        String result = instance.getWord();
        System.out.println(result);
        assertNotEquals(expResult, result);
        assertNotNull(result);
    }
    
}
