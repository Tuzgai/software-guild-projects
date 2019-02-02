package com.sg.vendingmachine.dao;

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
public class VendingMachineDaoFileImplTest {

    VendingMachineDaoFileImpl instance = new VendingMachineDaoFileImpl();

    public VendingMachineDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    // Each test, set up the class to have two items
    @Before
    public void setUp() {
        instance.clearInventory();
        InventoryItem item = new InventoryItem("Test Item 1");
        item.setPrice(new BigDecimal("1.50"));
        item.setStockLevel(1);
        instance.addItem(item);

        InventoryItem item2 = new InventoryItem("Test Item 2");
        item.setPrice(new BigDecimal("2.50"));
        item.setStockLevel(2);
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
     */
    @Test
    public void testGetItem() {
        InventoryItem item = new InventoryItem("Test Item 3");
        item.setPrice(new BigDecimal("3.50"));
        item.setStockLevel(3);
        instance.addItem(item);

        assertEquals(item, instance.getItem("Test Item 3"));
    }

    /**
     * Test of updateItem method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testUpdateItem() {
        InventoryItem item = instance.getItem("Test Item 1");

        item.setPrice(new BigDecimal("5"));
        instance.updateItem(item);

        item = instance.getItem("Test Item 1");
        assertEquals(new BigDecimal("5"), item.getPrice());
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
     * Test of loadItems method, of class VendingMachineDaoFileImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveAndLoadItems() throws Exception {
        instance.saveItems();
        instance.clearInventory();
        instance.loadItems();
        assertNotEquals(0, instance.getAllItems().size());
    }
}
