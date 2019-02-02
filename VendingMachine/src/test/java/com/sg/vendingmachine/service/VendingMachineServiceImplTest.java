package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
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
public class VendingMachineServiceImplTest {

    VendingMachineServiceImpl instance = new VendingMachineServiceImpl(new VendingMachineDaoStubImpl());

    public VendingMachineServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new VendingMachineServiceImpl(new VendingMachineDaoStubImpl());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMoney and getBalance methods, of class
     * VendingMachineServiceImpl.
     */
    @Test
    public void testAddMoneyAndGetBalance() {
        instance.addMoney(new BigDecimal("5"));
        assertEquals(new BigDecimal("5"), instance.getBalance());
    }

    /**
     * Test of getItem method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        // Passthrough from dao, no tests
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testGetAllItems() {
        // Passthrough from dao, no tests
    }

    /**
     * Test of vendItem method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testVendItem() throws Exception {
        instance.addMoney(new BigDecimal("5"));
        BigDecimal bal = instance.getBalance();
        instance.vendItem("Only Item");
        assertEquals(bal.subtract(new BigDecimal("1")), instance.getBalance());
        assertEquals(0, instance.getItem("Only Item").getStockLevel());
    }

    @Test(expected = InsufficientFundsException.class)
    public void testVendItemNoMoney() throws Exception {
        instance.coinReturn();
        instance.vendItem("Only Item");
    }

    @Test(expected = ZeroInventoryException.class)
    public void testVendItemNoInventory() throws Exception {
        instance.addMoney(new BigDecimal("5"));
        instance.vendItem("Only Item"); 
        instance.vendItem("Only Item");
    }
    
     /**
     * Test of coinReturn method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testCoinReturn() {
        instance.addMoney(new BigDecimal("5"));
        Change change = instance.coinReturn();
        assertEquals(new BigDecimal("0"), instance.getBalance());
        assertEquals(20, change.getQuarters());
    }
    
}
