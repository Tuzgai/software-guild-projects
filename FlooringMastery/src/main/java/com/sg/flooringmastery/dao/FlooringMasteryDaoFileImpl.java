package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {

    private String path;
    private static final String TRAINING_FILE = "trainingMode.txt";
    private static final String TAX_FILE = "Taxes.txt";
    private static final String PRODUCT_FILE = "Products.txt";
    private static final String DELIMITER = ",";
    private static final String ORDER_PREFIX = "Orders_";

    FlooringMasteryDaoFileImpl(String path) {
        this.path = path;
    }

    @Override
    public HashMap<String, Integer> loadTaxes() throws FlooringMasteryDaoFileException {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scn;

        try {
            scn = new Scanner(new File(path + TAX_FILE));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("File not found: " + TAX_FILE);
        }

        String currentLine;
        String[] currentTokens;
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lines
            if (currentTokens.length == 2) {
                map.put(currentTokens[0], Integer.parseInt(currentTokens[1]));
            }
        }

        scn.close();
        return map;
    }

    @Override
    public ArrayList<ProductType> loadProducts() throws FlooringMasteryDaoFileException {
        ArrayList<ProductType> list = new ArrayList<>();
        Scanner scn;
        ProductType product;

        try {
            scn = new Scanner(new File(path + PRODUCT_FILE));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("File not found: " + PRODUCT_FILE);
        }

        String currentLine;
        String[] currentTokens;

        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(",");

            // Skip malformed lines
            if (currentTokens.length == 3) {
                product = new ProductType(
                        currentTokens[0],
                        new BigDecimal(currentTokens[1]),
                        new BigDecimal(currentTokens[2]));
                list.add(product);
            }

        }

        return list;
    }

    @Override
    public ArrayList<Order> loadOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadTrainingMode() throws FlooringMasteryDaoFileException {
        Scanner scn;
        File file = new File(path + TRAINING_FILE);

        // If there's a file there, we are in training mode.
        return file.exists();
    }

    @Override
    public void saveOrdersByDate(ArrayList<Order> orders) throws FlooringMasteryDaoFileException {
        LocalDate date = orders.get(0).getDate();
        String filename = path + ORDER_PREFIX + serializeDate(date) + ".txt";
        File file = new File(filename);
        PrintWriter writer;
        
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new FlooringMasteryDaoFileException("Order file could not be created.");
            }
        }
        
        try {
            writer = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new FlooringMasteryDaoFileException("Could not open order file.");
        }
        
        orders.forEach(order -> writer.println(
                order.getOrderNumber() + DELIMITER +
                order.getCustName() + DELIMITER +
                order.getState() + DELIMITER +
                order.getTaxRate() + DELIMITER +
                order.getProductType() + DELIMITER +
                order.getAreaSquareFeet() + DELIMITER +
                order.getMaterialCostPerSquareFoot() + DELIMITER +
                order.getLaborCostPerSquareFoot() + DELIMITER +
                order.getMaterialCost() + DELIMITER +
                order.getLaborCost() + DELIMITER +
                order.getTaxCharged() + DELIMITER +
                order.getTotal()));
        
        writer.close();
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
