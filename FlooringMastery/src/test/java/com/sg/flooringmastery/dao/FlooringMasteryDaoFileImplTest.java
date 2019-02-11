package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
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
public class FlooringMasteryDaoFileImplTest {
    
    FlooringMasteryDao instance = new FlooringMasteryDaoFileImpl();

    public FlooringMasteryDaoFileImplTest() {
        
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
    public void testLoadTaxes() {
        instance.setPath("/testing/");
        HashMap map = instance.loadTaxes();
        assertTrue(map.size() > 0);
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadTaxesNoFile() {
        instance.setPath("/testing/emptyDir/");
        instance.loadTaxes();
    }

    @Test
    public void testLoadOrdersByDate() {
        instance.setPath("/testing/");
        ArrayList list = instance.loadOrdersByDate(LocalDate.of(12, 12, 1997));
        assertTrue(list.size() > 0);
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadOrdersByDateNoneExist() {
        instance.setPath("/testing/emptyDir/");
        instance.loadOrdersByDate(LocalDate.of(12,12,1997));
    }

    @Test
    public void testLoadTrainingMode() {
        instance.setPath("/testing/");
        assertTrue(instance.loadTrainingMode());
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadTrainingModeNoFile() {
        instance.setPath("/testing/emptyDir/");
        instance.loadTrainingMode();
    }
    
    @Test
    public void testSaveOrder() {
        instance.setPath("/testing/");
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order(1, LocalDate.now(), "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        instance.saveOrder(order);
        
        // confirm we succeeded
        File file = new File("/testing/1_" + String.join("", LocalDate.now().toString().split("-")) + ".txt");
        
        assertTrue(file.exists());
        
        // Clear the file
        if(file.exists()) {
            file.delete();
        }
    }
    
    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testSaveOrderFileAlreadyExists() {
        instance.setPath("/testing/");
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order(1, LocalDate.of(1,1,1997), "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        instance.saveOrder(order);
    }
    
    @Test
    public void testUpdateOrder() {
        instance.setPath("/testing/update/");
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order(1, LocalDate.of(1,1,1997), "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        instance.saveOrder(order);
        
        Order order2 = new Order(1, LocalDate.of(1,1,1997), "NewCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        
        ArrayList<Order> list = instance.loadOrdersByDate(LocalDate.of(1,1,1997));
        
        assertEquals("NewCust", list.get(0).getCustName());
        
        // Clean up
        File file = new File("/testing/update/1_" + String.join("", LocalDate.of(1,1,1997).toString().split("-")) + ".txt");
          
        if(file.exists()) {
            file.delete();
        }
        
    }
    
    @Test(expected = FlooringMasteryDaoFileException.class) 
    public void testUpdateOrderFileDoesNotExist() {
        instance.setPath("/testing/emptyDir/");
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order(1, LocalDate.now(), "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        instance.updateOrder(order);
    }
}
