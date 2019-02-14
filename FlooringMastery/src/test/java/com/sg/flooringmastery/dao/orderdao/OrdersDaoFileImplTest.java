package com.sg.flooringmastery.dao.orderdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class OrdersDaoFileImplTest {
    OrderDaoFileImpl instance = new OrderDaoFileImpl("./testing/");
    
    public OrdersDaoFileImplTest() {
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
    public void testSaveOrdersByDateAndLoadOrders() throws FlooringMasteryDaoFileException, FlooringMasteryDaoDataException {
        LocalDate date = LocalDate.now();
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setOrderNumber(1);
        order.setCustName("Test Cust");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("0.05"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("25.00"));
        order.setMaterialCost(new BigDecimal("0.00"));
        order.setLaborCost(new BigDecimal("0.00"));
        order.setTaxPaid(new BigDecimal("0.00"));
        order.setTotal(new BigDecimal("0.00"));
        
        
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        instance.saveOrdersByDate(orderList);
        
        // Confirm we succeeded in creating a file
        File file = new File("./testing/Orders_" + instance.serializeDate(date)  + ".txt");
        assertTrue(file.exists());
        
        // Confirm there's something in the file
        ArrayList<Order> loadedOrderList = instance.loadOrdersByDate(date);
        assertEquals(1, loadedOrderList.size());
       
        // Confirm it's the thing we put in there
        assertTrue(loadedOrderList.get(0).equals(order));
        
        // Clear the file
        if(file.exists()) {
            file.delete();
        }
    }
    
    @Test(expected = FlooringMasteryDaoDataException.class)
    public void testSaveOrdersByDateAndLoadOrdersNoData() throws FlooringMasteryDaoFileException, FlooringMasteryDaoDataException {
        ArrayList<Order> orderList = new ArrayList<>();
        instance.saveOrdersByDate(orderList);
    }
    
    @Test
    public void testSerializeDate() {
        LocalDate date = LocalDate.of(1997, 1, 30);
        String expectedValue = "01301997";
        
        assertEquals(expectedValue, instance.serializeDate(date));
        
    }
    
    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadOrdersByDateNoneExist() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/emptyDir/");
        instance.loadOrdersByDate(LocalDate.of(1997,12,30));
    }
    
}
