package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private InventoryItem onlyItem;
    private HashSet<InventoryItem> itemList = new HashSet<>();
    private final MathContext mc;

    public VendingMachineDaoStubImpl() {
        this.mc = new MathContext(2, RoundingMode.HALF_UP);
        onlyItem = new InventoryItem("Only Item");
        onlyItem.setPrice(new BigDecimal("1.00", mc));
        onlyItem.setStockLevel(1);

        itemList.add(onlyItem);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        list.add(onlyItem);
        return list;
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        // do nothing
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
        itemList.clear();
    }

    @Override
    public void saveItems(List<InventoryItem> items) throws VendingMachineDaoException {
        // Do nothing
    }
    
}
