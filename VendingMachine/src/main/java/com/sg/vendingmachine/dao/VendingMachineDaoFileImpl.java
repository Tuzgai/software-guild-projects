package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    ArrayList<InventoryItem> itemList;
    final static String FILE = "items.txt";
    final static String DELIMITER = "::";

    public VendingMachineDaoFileImpl() {
        this.itemList = new ArrayList<>();
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        itemList.forEach(item -> list.add(item));

        return list;
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
                itemList.add(item);
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

        itemList.forEach(item -> out.println(
                item.getName() + DELIMITER
                + item.getPrice() + DELIMITER
                + item.getStockLevel() + DELIMITER));

        out.close();
    }

    @Override
    public void clearInventory() {
        itemList.clear();
    }
}
