package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    HashSet<InventoryItem> itemSet;
    final static String FILE = "items.txt";
    final static String DELIMITER = "::";

    public VendingMachineDaoFileImpl() {
        this.itemSet = new HashSet<>();
    }

    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        itemSet.forEach(item -> list.add(item));

        return list;
    }

    @Override
    public InventoryItem getItem(String name) {
        for (InventoryItem item : itemSet) {
            if(name.equals(item.getName())) return item;
        }
        
        return null;
    }

    // Presently adding / updating are the same thing but they might not always be,
    // so two methods are needed to make future changes easier.
    @Override
    public void updateItem(InventoryItem item) {
        addItem(item);
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        itemSet.add(item);
    }

    @Override
    public void loadItems() throws VendingMachineDaoException {
        Scanner scn;
        InventoryItem item;
        try {
            scn = new Scanner(new File(FILE));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not open " + FILE, e);
        }

        String currentLine;
        String[] currentTokens;
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lines
            if (currentTokens.length == 3) {
                item = new InventoryItem(currentTokens[0]);
                item.setPrice(new BigDecimal(currentTokens[1]));
                item.setStockLevel(Integer.parseInt(currentTokens[2]));
                itemSet.add(item);
            }

        }
        scn.close();
    }

    @Override
    public void saveItems() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not save inventory data.", e);
        }

        itemSet.forEach(item -> out.println(
                item.getName() + DELIMITER
                + item.getPrice() + DELIMITER
                + item.getStockLevel() + DELIMITER));

        out.close();
    }

    @Override
    public void clearInventory() {
        itemSet.clear();
    }
}
