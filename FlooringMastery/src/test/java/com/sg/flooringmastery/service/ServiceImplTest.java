package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Stuart
 */
public class ServiceImplTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service instance = ctx.getBean("serviceLayer", Service.class);

    public ServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FlooringMasteryDaoFileException {
        instance.clearOrderList();
        LocalDate date = LocalDate.of(1997, 1, 30);
        instance.getOrdersByDate(date);
        int i = 0;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUpdateOrder() throws FlooringMasteryDaoFileException, FlooringMasteryServiceException {
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate date = LocalDate.of(1997, 1, 30);
        Order order = new Order();
        order.setDate(date);
        order.setOrderNumber(2);
        order.setCustName("Test Cust 3");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("3.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("3.00"));
        order.setMaterialCost(new BigDecimal("3.00"));
        order.setLaborCost(new BigDecimal("3.00"));
        order.setTaxPaid(new BigDecimal("3.00"));
        order.setTotal(new BigDecimal("3.00"));

        instance.updateOrder(order);
        Order order2 = instance.getOrderByNumber(2);
        assertEquals(order, order2);
    }

    @Test(expected = FlooringMasteryServiceException.class)
    public void testUpdateOrderNoExistingOrder() throws FlooringMasteryDaoFileException, FlooringMasteryServiceException{
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate date = LocalDate.of(1997, 1, 30);
        Order order = new Order();
        order.setDate(date);
        order.setOrderNumber(3);
        order.setCustName("Test Cust 3");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("3.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("3.00"));
        order.setMaterialCost(new BigDecimal("3.00"));
        order.setLaborCost(new BigDecimal("3.00"));
        order.setTaxPaid(new BigDecimal("3.00"));
        order.setTotal(new BigDecimal("3.00"));

        instance.updateOrder(order);
    }
    
    @Test(expected = FlooringMasteryServiceException.class)
    public void testUpdateOrderBeforeLoadingOrders() throws FlooringMasteryDaoFileException, FlooringMasteryServiceException{
        instance.clearOrderList();
        
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate date = LocalDate.of(1997, 1, 30);
        Order order = new Order();
        order.setDate(date);
        order.setOrderNumber(3);
        order.setCustName("Test Cust 3");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("3.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("3.00"));
        order.setMaterialCost(new BigDecimal("3.00"));
        order.setLaborCost(new BigDecimal("3.00"));
        order.setTaxPaid(new BigDecimal("3.00"));
        order.setTotal(new BigDecimal("3.00"));

        instance.updateOrder(order);
    }


    @Test
    public void testSaveNewOrder() throws FlooringMasteryDaoFileException, FlooringMasteryServiceException {
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate date = LocalDate.of(1997, 1, 30);
        Order order = new Order();
        order.setDate(date);
        order.setOrderNumber(3);
        order.setCustName("Test Cust 3");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("3.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("3.00"));
        order.setMaterialCost(new BigDecimal("3.00"));
        order.setLaborCost(new BigDecimal("3.00"));
        order.setTaxPaid(new BigDecimal("3.00"));
        order.setTotal(new BigDecimal("3.00"));
        
        instance.saveNewOrder(order);
        
        Order order2 = instance.getOrderByNumber(3);
        assertEquals(order, order2);
    }

    
    @Test
    public void testGetOrdersByDate() throws FlooringMasteryDaoFileException {
        LocalDate date = LocalDate.of(1997, 1, 30);
        ArrayList<Order> orderList = instance.getOrdersByDate(date);
        assertEquals(2, orderList.size());
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testGetOrdersByDateNoFile() throws FlooringMasteryDaoFileException {
        LocalDate date = LocalDate.of(1997, 1, 15);
        ArrayList<Order> orderList = instance.getOrdersByDate(date);
    }

    @Test
    public void testGetOrderByNumber_1() throws FlooringMasteryServiceException {
        // Service layer is expected to convert user order numbers to internal
        // representation. 1 is the first order.
        Order testOrder = instance.getOrderByNumber(1);
        assertEquals("Test Cust", testOrder.getCustName());
    }

    @Test
    public void testGetOrderByNumber_2() throws FlooringMasteryServiceException {
        // Service layer is expected to convert user order numbers to internal
        // representation. 1 is the first order.
        Order testOrder = instance.getOrderByNumber(2);
        assertEquals("Test Cust 2", testOrder.getCustName());
    }

    @Test(expected = FlooringMasteryServiceException.class)
    public void testGetOrdersByNumberOrderDoesntExist() throws FlooringMasteryServiceException {
        Order testOrder = instance.getOrderByNumber(3);
    }
    
    @Test(expected = FlooringMasteryServiceException.class)
    public void testGetOrdersByNumberOrdersNotLoaded() throws FlooringMasteryServiceException {
        instance.clearOrderList();
        Order testOrder = instance.getOrderByNumber(1);
    }
    
    @Test
    public void testRemoveOrder() throws FlooringMasteryServiceException, FlooringMasteryDaoFileException {
        Order order = instance.getOrderByNumber(1);
        
        instance.removeOrder(order);
        order = instance.getOrderByNumber(1);
        
        assertEquals("Test Cust 2", order.getCustName());
    }
    
    @Test(expected = FlooringMasteryServiceException.class)
    public void testRemoveOrderOrdersNotLoaded() throws FlooringMasteryServiceException, FlooringMasteryDaoFileException {
        Order order = instance.getOrderByNumber(1);
        
        instance.clearOrderList();
        instance.removeOrder(order);
    }
    
    @Test(expected = FlooringMasteryServiceException.class)
    public void testRemoveOrderOrderDoesNotExist() throws FlooringMasteryServiceException, FlooringMasteryDaoFileException {
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate date = LocalDate.of(1997, 1, 30);
        Order order = new Order();
        order.setDate(date);
        order.setOrderNumber(3);
        order.setCustName("Test Cust 3");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("3.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("3.00"));
        order.setMaterialCost(new BigDecimal("3.00"));
        order.setLaborCost(new BigDecimal("3.00"));
        order.setTaxPaid(new BigDecimal("3.00"));
        order.setTotal(new BigDecimal("3.00"));
        
        instance.removeOrder(order);
    }

}
