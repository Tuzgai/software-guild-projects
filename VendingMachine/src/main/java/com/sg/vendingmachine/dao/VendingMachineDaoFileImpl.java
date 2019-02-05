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

    private ArrayList<InventoryItem> itemList;
    private final static String FILE = "items.txt";
    private final static String DELIMITER = "::";

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
        try {
            saveItems(itemList);
        } catch (VendingMachineDaoException e) {
            throw e;
        }
    }

    @Override
    public void saveItems(List<InventoryItem> items) throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not save inventory data.", e);
        }

        items.forEach(item -> out.println(
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
