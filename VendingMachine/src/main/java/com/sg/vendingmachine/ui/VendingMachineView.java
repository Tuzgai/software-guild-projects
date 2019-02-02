package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineView {

    public void displayMachine(List<InventoryItem> items) {

    }

    public int displayMainMenuAndGetChoice(List<InventoryItem> items) {
        return 1;
    }
    
    public void displayGoodByeMessage(Change change) {
        
    }
    
    public BigDecimal getFunds() {
        return new BigDecimal("0");
    }
}
