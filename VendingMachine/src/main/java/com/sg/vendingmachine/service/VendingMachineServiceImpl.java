package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    BigDecimal balance;
    List items;

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
        balance = new BigDecimal("0");
        items = dao.getAllItems().sort();
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    
    @Override
    public InventoryItem getItem(String name) throws ItemNotFoundException {
        InventoryItem item = dao.getItem(name);
        if (item == null) {
            throw new ItemNotFoundException("Item does not exist: " + name);
        }
        return item;
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public BigDecimal addMoney(BigDecimal money) {
        balance = balance.add(money);
        return balance;
    }

    @Override
    public void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException {
        try {
            InventoryItem item = getItem(name);
            if (balance.compareTo(item.getPrice()) < 0) throw new InsufficientFundsException("Insufficient funds, please add more and try again.");
            
            if (item.getStockLevel() <= 0) throw new ZeroInventoryException("Item out of stock.");
            
            balance = balance.subtract(item.getPrice());
            item.setStockLevel(item.getStockLevel() - 1);
            dao.updateItem(item);
        } catch (ItemNotFoundException e) {
            throw e;
        }     
    }
    
    @Override
    public Change coinReturn() {
        Change change = new Change(balance);
        balance = new BigDecimal("0");
        return change;
    }

}
