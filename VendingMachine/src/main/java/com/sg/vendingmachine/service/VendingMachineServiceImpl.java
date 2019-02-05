package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineDao dao;
    private BigDecimal balance;
    private List<InventoryItem> itemList;

    public VendingMachineServiceImpl(VendingMachineDao dao) throws VendingMachineDaoException {
        this.dao = dao;
        balance = new BigDecimal("0.00");
        try {
            dao.loadItems();
        } catch (VendingMachineDaoException e) {
            throw e;
        }
        itemList = dao.getAllItems();
        itemList.sort(Comparator.comparing(InventoryItem::getName));
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    // Don't worry about which property changed, just replace the item
    @Override
    public void updateItem(InventoryItem item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (item.getName().equals(itemList.get(i).getName())) {
                itemList.remove(i);
                itemList.add(i, item);
            }
        }
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    @Override
    public InventoryItem getItem(String name) throws ItemNotFoundException {
        for (InventoryItem item : itemList) {
            if (name.equals(item.getName())) {
                return item;
            }
        }

        throw new ItemNotFoundException("Item does not exist.");
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return itemList;
    }

    @Override
    public BigDecimal addMoney(BigDecimal money) {
        balance = balance.add(money);
        return balance;
    }

    @Override
    public void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException {
        InventoryItem item = getItem(name);
        if (item.getStockLevel() <= 0) {
            throw new ZeroInventoryException("Item out of stock.");
        }

        if (balance.compareTo(item.getPrice()) < 0) {
            throw new InsufficientFundsException("Insufficient funds, please add more and try again.");
        }

        balance = balance.subtract(item.getPrice());
        item.setStockLevel(item.getStockLevel() - 1);
        updateItem(item);
    }

    @Override
    public Change coinReturn() {
        Change change = new Change(balance);
        balance = new BigDecimal("0.00");
        return change;
    }

    // Needed for testing
    @Override
    public void clearInventory() {
        itemList.clear();
    }

    @Override
    public void quit() throws VendingMachineDaoException {

        dao.saveItems(itemList);

    }
}
