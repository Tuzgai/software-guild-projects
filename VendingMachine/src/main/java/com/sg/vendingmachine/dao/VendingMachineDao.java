package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface VendingMachineDao {
    List<InventoryItem> getAllItems(); 
    void updateItem(InventoryItem item);
    void addItem(InventoryItem item); 
    InventoryItem getItem(String name);
    void loadItems() throws VendingMachineDaoException;
    void saveItems() throws VendingMachineDaoException;
    void clearInventory();
}
