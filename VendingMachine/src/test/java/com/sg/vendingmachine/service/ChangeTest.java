package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import java.math.BigDecimal;
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
public class ChangeTest {

    Change instance = new Change();

    public ChangeTest() {
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
    public void testJustQuarters() {
        instance.setBalance(new BigDecimal("1.0"));
        assertEquals(4, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndDimes() {
        instance.setBalance(new BigDecimal("1.10"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndNickelsAndDimes() {
        instance.setBalance(new BigDecimal("1.15"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndNickelsAndDimesandPennies() {
        instance.setBalance(new BigDecimal("1.16"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }
    
    @Test
    public void testZeroBalance() {
        instance.setBalance(new BigDecimal("0"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }
    
    @Test
    public void testDimesAndNickelsAndPennies() {
        instance.setBalance(new BigDecimal("0.16"));
        assertEquals(0, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }
    
        @Test
    public void testNickelsAndPennies() {
        instance.setBalance(new BigDecimal("0.06"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }
        @Test
    public void testPennies() {
        instance.setBalance(new BigDecimal("0.03"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(3, instance.getPennies());
    }
    
        @Test
    public void testNickels() {
        instance.setBalance(new BigDecimal("0.05"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }
    
        @Test
    public void testDimes() {
        instance.setBalance(new BigDecimal("0.20"));
        assertEquals(0, instance.getQuarters());
        assertEquals(2, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }
}
