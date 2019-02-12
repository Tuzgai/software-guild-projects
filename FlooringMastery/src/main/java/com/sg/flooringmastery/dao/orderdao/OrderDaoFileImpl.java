package com.sg.flooringmastery.dao.orderdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
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
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class OrderDaoFileImpl implements OrderDao {

    private static final String DELIMITER = ",";
    private static final String ORDER_PREFIX = "Orders_";
    private String path;

    public OrderDaoFileImpl(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Order> loadOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException {
        ArrayList<Order> list = new ArrayList<>();
        Scanner scn;
        ProductType product;
        File file = new File(path + ORDER_PREFIX + serializeDate(date) + ".txt");

        try {
            scn = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("File not found for date: " + date.toString());
        }

        String currentLine;
        String[] currentTokens;
        Order order = new Order();
        
        // Skip the heading line
        scn.nextLine();
        
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lists
            if (currentTokens.length == 12) {
                order.setDate(date);
                order.setOrderNumber(Integer.parseInt(currentTokens[0]));
                order.setCustName(currentTokens[1]);
                order.setState(currentTokens[2]);
                order.setTaxRate(new BigDecimal(currentTokens[3]));
                String productName = currentTokens[4];
                order.setAreaSquareFeet(new BigDecimal(currentTokens[5]));
                BigDecimal materialPerSqFt = new BigDecimal(currentTokens[6]);
                BigDecimal laborPerSqFt = new BigDecimal(currentTokens[7]);
                order.setMaterialCost(new BigDecimal(currentTokens[8]));
                order.setLaborCost(new BigDecimal(currentTokens[9]));
                order.setTaxPaid(new BigDecimal(currentTokens[10]));
                order.setTotal(new BigDecimal(currentTokens[11]));
                order.setProductType(new ProductType(productName, materialPerSqFt, laborPerSqFt));
                list.add(order);
            }
        }
        scn.close();
        return list;
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

        writer.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCost"
                + "PerSquareFoot,MaterialCost,LaborCost,Tax,Total");

        orders.forEach(order -> writer.println(
                order.getOrderNumber() + DELIMITER
                + order.getCustName() + DELIMITER
                + order.getState() + DELIMITER
                + order.getTaxRate() + DELIMITER
                + order.getProductType().getName() + DELIMITER
                + order.getAreaSquareFeet() + DELIMITER
                + order.getMaterialCostPerSquareFoot() + DELIMITER
                + order.getLaborCostPerSquareFoot() + DELIMITER
                + order.getMaterialCost() + DELIMITER
                + order.getLaborCost() + DELIMITER
                + order.getTaxPaid() + DELIMITER
                + order.getTotal()));

        writer.close();
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
