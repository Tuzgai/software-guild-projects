package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import com.sg.vendingmachine.service.ItemNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class VendingMachineView {

    private UserIO io;
    private static final int MARGIN = 15;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

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
            if ((0 <= i && i <= items.size()) || i == 400 || i == 999) {
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

    public int displayAdminMenuAndGetChoice() {
        int numberOfOptions = 6;
        io.println("=== ADMIN MENU ===");
        io.println("1. Refill machine with all items.");
        io.println("2. Add a new item to inventory.");
        io.println("3. Remove an item from inventory.");
        io.println("4. Edit an item's price or inventory level.");
        io.println("5. Add coins to stock.");
        io.println("6. Save and exit.");
        return io.readInt("Enter your selection: ", 1, numberOfOptions);
    }

    public int getRefillSelection() {
        return io.readInt("Enter new stock level for all items (0 to cancel): ", 0, 8);
    }

    public InventoryItem getNewItem() {
        String name = io.readString("Enter item name: ");
        InventoryItem newItem = new InventoryItem(name);

        newItem.setPrice(io.readCurrency("Enter item cost (format dd.cc): "));
        newItem.setStockLevel(io.readInt("Enter starting stock level: "));

        return newItem;
    }

    public void displayItemList(List<InventoryItem> itemList) {
        io.println("======================");
        io.println("=== INVENTORY LIST ===");
        io.println("======================");
        int displayIndex = 0;
        for (int i = 0; i < itemList.size(); i++) {
            InventoryItem item = itemList.get(i);
            displayIndex = i+1;
            io.println(displayIndex + ". " + item.getName() + " $"
                    + item.getPrice() + " Stock: "
                    + item.getStockLevel());
        }
        io.println("======================");
    }

    public int getItemToDelete(List<InventoryItem> itemList) {
        displayItemList(itemList);
        return io.readInt("Select an item to delete (0 to cancel): ", 0, itemList.size()) - 1;
    }

    public InventoryItem getEdit(List<InventoryItem> itemList) throws ItemNotFoundException {
        displayItemList(itemList);
        InventoryItem newItem;
        int choice = io.readInt("Select an item to edit (0 to cancel): ", 0, itemList.size()) - 1;
        if (-1 < choice && choice < itemList.size()) {
            newItem = itemList.get(choice);
            newItem.setPrice(io.readCurrency("Enter item cost (format dd.cc): "));
            newItem.setStockLevel(io.readInt("Enter starting stock level: "));
        } else {
            throw new ItemNotFoundException("Item not found.");
        }
        
        return newItem;
    }
}
