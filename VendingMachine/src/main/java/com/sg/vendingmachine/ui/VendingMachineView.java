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

    private UserIO io = new UserIOConsoleImpl();
    private static final int MARGIN = 15;
    
    public void displayMachine(List<InventoryItem> items, BigDecimal balance) {
        StringBuilder s;
        io.println("+----------------------------+");
        io.println("|           SNACKS           |");
        io.println("|                            |");

        // Print lines of inventory if there's any stock left
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getStockLevel() != 0) {
                s = new StringBuilder();
                int printMargin = MARGIN - items.get(i).getName().length();
                
                // Left margin
                s.append("| ").append(i + 1).append("| ");
                
                // Name
                s.append(items.get(i).getName());
                
                // Internal margin (variable length)
                for (int j = 0; j < printMargin; j++) {
                    s.append(" ");
                }
                
                // Price + right margin
                s.append("$").append(items.get(i).getPrice());
                s.append("    |");
                io.println(s.toString());
            }
        }

        io.println("|                            |");
        io.println("| 0 - Coin Return            |");
        io.println("| 400 - Add Funds            |");
        io.println("|                            |");

        // One space adjustment for shorter/longer prices
        if (balance.compareTo(new BigDecimal("10.00")) >= 0) {
            io.println("| " + "Current Balance: $" + balance + "    |");
        } else {
            io.println("| " + "Current Balance: $" + balance + "     |");
        }

        io.println("|          +-------+         |");
        io.println("|          |       |         |");
        io.println("+----------+-------+---------+");

    }

    public int displayMainMenuAndGetChoice(List<InventoryItem> items, BigDecimal balance) {
        displayMachine(items, balance);
        int i;
        while (true) {
            i = io.readInt("Please enter your selection: ");
            if ((0 <= i && i <= items.size()) || i == 400) {
                return i;
            }
            io.println("Invalid selection, please try again.");
        }
    }

    public void displayGoodByeMessage(Change change) {
        io.println("=== Change returned ===");
        io.println("Quarters: " + change.getQuarters());
        io.println("Dimes: " + change.getDimes());
        io.println("Nickels: " + change.getNickels());
        io.println("Pennies: " + change.getPennies());
        io.println("Thanks for visiting, see you soon!");
    }

    public BigDecimal getDeposit() {
        return io.readCurrency("Enter your deposit (dollars.cents): ");
    }

    public void displayError(Exception e) {
        io.println(e.getMessage());
        io.readString("Press enter to continue.");
    }

    public void displayPurchase(String itemName) {
        io.println("Ker-CHUNK! You now have a " + itemName + "!");
        io.readString("Press enter to continue.");
    }
}
