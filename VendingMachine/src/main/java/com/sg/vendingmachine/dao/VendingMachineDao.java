package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface VendingMachineDao {
    
    List<InventoryItem> getAllItems();

    void addItem(InventoryItem item);

    void loadItems() throws VendingMachineDaoException;

    void saveItems() throws VendingMachineDaoException;
    
    void saveItems(List<InventoryItem> items) throws VendingMachineDaoException;
    
    void clearInventory();
    
    Change getCoins();
}
