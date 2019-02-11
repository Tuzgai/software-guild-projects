package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class OrderTest {

    ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
    Order instance = new Order(1, LocalDate.now(), "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
    
    public OrderTest() {
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
    public void testGetMaterialCost() {
        BigDecimal expectedValue = new BigDecimal("125.00");
        assertEquals(expectedValue, instance.getMaterialCost());
    }

    @Test
    public void testGetLaborCost() {
        BigDecimal expectedValue = new BigDecimal("250.00");
        assertEquals(expectedValue, instance.getLaborCost());
    }
    
    @Test
    public void testGetTaxCharged() {
        BigDecimal expectedValue = new BigDecimal("18.75");
        assertEquals(expectedValue, instance.getTaxCharged());
    }
    
    @Test
    public void testGetTotal() {
        BigDecimal expectedValue = new BigDecimal("393.75");
        assertEquals(expectedValue, instance.getTotal());
    }

}
