package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    InventoryItem onlyItem;
    HashSet<InventoryItem> itemList = new HashSet<>();
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new InventoryItem("Only Item");
        onlyItem.setPrice(new BigDecimal("1"));
        onlyItem.setStockLevel(1);
        
        itemList.add(onlyItem);
    }
    
    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        list.add(onlyItem);
        return list;
    }

    @Override
    public void updateItem(InventoryItem item) {
        onlyItem = item;
    }

    @Override
    public void addItem(InventoryItem item) {
        // do nothing
    }

    @Override
    public InventoryItem getItem(String name) {
        return onlyItem;
    }

    @Override
    public void loadItems() throws VendingMachineDaoException {
        // do nothing
    }

    @Override
    public void saveItems() throws VendingMachineDaoException {
        // do nothing
    }

    @Override
    public void clearInventory() {
        // do nothing
    }
    
}
