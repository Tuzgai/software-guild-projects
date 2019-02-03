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

    UserIO io = new UserIOConsoleImpl();
    public static final int MARGIN = 15;

    public void displayMachine(List<InventoryItem> items, BigDecimal balance) {
        StringBuilder s = new StringBuilder();
        io.println("+----------------------------+");
        io.println("|           SNACKS           |");
        io.println("|                            |");
        
        // Print lines of inventory
        for (int i = 1; i < items.size()+1; i++) {
            int printMargin = MARGIN - items.get(i - 1).getName().length();
            s.append("| ").append(i).append(" ");
            s.append(items.get(i - 1).getName());
            for (int j = 0; j < printMargin; j++) {
                s.append(" ");
            }
            s.append("$").append(items.get(i - 1).getPrice());
            s.append("     |");
            io.println(s.toString());
        }

        io.println("|                            |");
        io.println("| 0 - Coin Return            |");
        io.println("| 400 - Add Funds            |");
        io.println("|                            |");
        io.println("| " + "Current Balance: $" + balance + "     |");
        io.println("|          +-------+         |");
        io.println("|          |       |         |");
        io.println("+----------+-------+---------+");

    }

    public int displayMainMenuAndGetChoice(List<InventoryItem> items, BigDecimal balance) {
        displayMachine(items, balance);
        int i;
        do {
        i = io.readInt("Please enter your selection: ");
        } while(!(i >= 0 && (i <= items.size()+1 || i == 400)));
        
        return i;
    }

    public void displayGoodByeMessage(Change change) {
        io.println("Change returned: ");
        io.println("Quarters: " + change.getQuarters());
        io.println("Dimes: " + change.getDimes());
        io.println("Nickels: " + change.getNickels());
        io.println("Pennies: " + change.getPennies());
        io.println("Thanks for visiting, see you soon!");
    }

    public BigDecimal getDeposit() {
        return io.readCurrency("Enter your deposit (dd.cc): ");
    }

    public void displayError(Exception e) {
        io.println(e.getMessage());
        io.readString("Press enter to continue.");
    }
}
