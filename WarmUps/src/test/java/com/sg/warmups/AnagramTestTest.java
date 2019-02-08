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
public class AnagramTestTest {

    AnagramTest instance = new AnagramTest();

    public AnagramTestTest() {
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
    public void testPalindrome() {
        String a = "dog";
        String b = "god";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void testAnagram2() {
        String a = "doggo";
        String b = "goodg";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void testNoAnagram() {
        String a = "doggo";
        String b = "good";
        assertFalse(instance.anagramTest(a, b));
    }

    @Test
    public void testNoAnagram2() {
        String a = "dogg";
        String b = "goodg";
        assertFalse(instance.anagramTest(a, b));
    }

    @Test
    public void testNoAnagramSameLength() {
        String a = "dogfo";
        String b = "goodg";
        assertFalse(instance.anagramTest(a, b));
    }

    @Test
    public void testNoAnagramSameLength2() {
        String a = "doggo";
        String b = "goofg";
        assertFalse(instance.anagramTest(a, b));
    }

    @Test
    public void test2char() {
        String a = "go";
        String b = "og";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void test1char() {
        String a = "g";
        String b = "g";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void testSameWord() {
        String a = "good";
        String b = "good";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void testEmpty() {
        String a = "";
        String b = "";
        assertTrue(instance.anagramTest(a, b));
    }

    @Test
    public void testOneEmpty() {
        String a = "";
        String b = "good";
        assertFalse(instance.anagramTest(a, b));
    }
}
