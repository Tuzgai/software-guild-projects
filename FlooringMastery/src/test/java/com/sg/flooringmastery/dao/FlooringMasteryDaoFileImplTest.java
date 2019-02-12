package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    
    FlooringMasteryDao instance = new FlooringMasteryDaoFileImpl("/testing/");

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
    public void testLoadTaxes() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/");
        HashMap map = instance.loadTaxes();
        assertTrue(map.size() > 0);
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadTaxesNoFile() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/emptyDir/");
        instance.loadTaxes();
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadOrdersByDateNoneExist() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/emptyDir/");
        instance.loadOrdersByDate(LocalDate.of(12,12,1997));
    }

    @Test
    public void testLoadTrainingMode() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/");
        assertTrue(instance.loadTrainingMode());
    }

    public void testLoadTrainingModeNoFile() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/emptyDir/");
        assertFalse(instance.loadTrainingMode());
    }
    
    @Test
    public void testSaveOrdersByDateAndLoadOrders() throws FlooringMasteryDaoFileException {
        instance.setPath("/testing/");
        LocalDate date = LocalDate.now();
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order(1, date, "TestCust", "MN", new BigDecimal("0.05"), product, new BigDecimal("25.00"));
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        instance.saveOrdersByDate(orderList);
        
        // Confirm we succeeded in creating a file
        File file = new File("/testing/Orders_" + instance.serializeDate(date)  + ".txt");
        assertTrue(file.exists());
        
        // Confirm there's something in the file
        ArrayList<Order> loadedOrderList = instance.loadOrdersByDate(date);
        assertEquals(1, loadedOrderList.size());
       
        assertTrue(loadedOrderList.get(0).equals(order));
        
        // Clear the file
        if(file.exists()) {
            file.delete();
        }
    }
    
    @Test
    public void testSerializeDate() {
        LocalDate date = LocalDate.of(1, 1, 1997);
        String expectedValue = "01011997";
        
        assertEquals(expectedValue, instance.serializeDate(date));
        
    }
}
