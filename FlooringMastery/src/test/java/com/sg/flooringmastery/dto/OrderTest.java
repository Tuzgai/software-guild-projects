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

    Order instance;

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
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));

        instance = new Order();
        instance.setDate(LocalDate.now());
        instance.setOrderNumber(1);
        instance.setCustName("Test Cust");
        instance.setState("MN");
        instance.setTaxRate(new BigDecimal("0.05"));
        instance.setProductType(product);
        instance.setAreaSquareFeet(new BigDecimal("25.00"));
        instance.setMaterialCost(new BigDecimal("0.00"));
        instance.setLaborCost(new BigDecimal("0.00"));
        instance.setTaxPaid(new BigDecimal("0.00"));
        instance.setTotal(new BigDecimal("0.00"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUpdateDerivedFields() {
        instance.updateDerivedFields();
        BigDecimal expectedValue = new BigDecimal("125.00");
        assertEquals(expectedValue, instance.getMaterialCost());
        expectedValue = new BigDecimal("250.00");
        assertEquals(expectedValue, instance.getLaborCost());
        expectedValue = new BigDecimal("18.75");
        assertEquals(expectedValue, instance.getTaxPaid());
        expectedValue = new BigDecimal("393.75");
        assertEquals(expectedValue, instance.getTotal());
    }
}
