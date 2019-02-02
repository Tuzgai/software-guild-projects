package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface VendingMachineService {

    BigDecimal getBalance();

    InventoryItem getItem(String name) throws ItemNotFoundException;
    
    List<InventoryItem> getAllItems();

    BigDecimal addMoney(BigDecimal money);

    void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException;
    
    Change coinReturn();
}
