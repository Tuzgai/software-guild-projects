package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.InventoryItem;
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

    VendingMachineServiceImpl instance;

    public VendingMachineServiceImplTest() throws VendingMachineDaoException {
        this.instance = new VendingMachineServiceImpl(new VendingMachineDaoStubImpl());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws VendingMachineDaoException {
        instance.clearInventory();

        InventoryItem item = new InventoryItem("Test Item 1");
        item.setPrice(new BigDecimal("1.00"));
        item.setStockLevel(1);
        instance.addItem(item);

        InventoryItem item2 = new InventoryItem("Test Item 2");
        item2.setPrice(new BigDecimal("2.00"));
        item2.setStockLevel(2);
        instance.addItem(item2);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetAllItems() {
        assertEquals(2, instance.getAllItems().size());
    }

    /**
     * Test of getItem method, of class VendingMachineDaoFileImpl.
     *
     * @throws com.sg.vendingmachine.service.ItemNotFoundException
     */
    @Test
    public void testGetItem() throws ItemNotFoundException {
        InventoryItem item = new InventoryItem("Test Item 3");
        item.setPrice(new BigDecimal("3.50"));
        item.setStockLevel(3);
        instance.addItem(item);

        assertEquals(item, instance.getItem("Test Item 3"));
    }

    /**
     * Test of updateItem method, of class VendingMachineDaoFileImpl.
     *
     * @throws com.sg.vendingmachine.service.ItemNotFoundException
     */
    @Test
    public void testUpdateItem() throws ItemNotFoundException {
        InventoryItem item = instance.getItem("Test Item 1");

        item.setPrice(new BigDecimal("5.00"));
        instance.updateItem(item);

        item = instance.getItem("Test Item 1");
        assertEquals(new BigDecimal("5.00"), item.getPrice());
    }

    /**
     * Test of addItem method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testAddItem() {
        InventoryItem item = new InventoryItem("Test Item 3");
        item.setPrice(new BigDecimal("4.50"));
        item.setStockLevel(4);
        instance.addItem(item);

        assertEquals(3, instance.getAllItems().size());
    }

    /**
     * Test of clearInventory method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testclearInventory() {
        instance.clearInventory();
        assertEquals(0, instance.getAllItems().size());
    }

    /**
     * Test of addMoney and getBalance methods, of class
     * VendingMachineServiceImpl.
     */
    @Test
    public void testAddMoneyAndGetBalance() {
        instance.addMoney(new BigDecimal("5.00"));
        assertEquals(new BigDecimal("5.00"), instance.getBalance());
    }

    /**
     * Test of vendItem method, of class VendingMachineServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testVendItem() throws Exception {
        instance.addMoney(new BigDecimal("5.00"));
        BigDecimal bal = instance.getBalance();
        instance.vendItem("Test Item 1");
        assertEquals(bal.subtract(new BigDecimal("1.00")), instance.getBalance());
        assertEquals(0, instance.getItem("Test Item 1").getStockLevel());
    }

    @Test(expected = InsufficientFundsException.class)
    public void testVendItemNoMoney() throws Exception {
        instance.coinReturn();
        instance.vendItem("Test Item 1");
    }

    @Test(expected = ZeroInventoryException.class)
    public void testVendItemNoInventory() throws Exception {
        instance.addMoney(new BigDecimal("5"));
        instance.vendItem("Test Item 1");
        instance.vendItem("Test Item 1");
    }

    /**
     * Test of coinReturn method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testCoinReturn() {
        instance.addMoney(new BigDecimal("5.00"));
        Change change = instance.coinReturn();
        assertEquals(new BigDecimal("0.00"), instance.getBalance());
        assertEquals(20, change.getQuarters());
    }

}