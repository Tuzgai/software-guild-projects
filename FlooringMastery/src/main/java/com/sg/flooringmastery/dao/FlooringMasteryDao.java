package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Stuart
 */
public interface FlooringMasteryDao {

    public HashMap<String, Integer> loadTaxes() throws FlooringMasteryDaoFileException;

    public ArrayList<ProductType> loadProducts() throws FlooringMasteryDaoFileException;

    public ArrayList<Order> loadOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException;

    boolean loadTrainingMode() throws FlooringMasteryDaoFileException;

    public void saveOrdersByDate(ArrayList<Order> orders)  throws FlooringMasteryDaoFileException;

    void setPath(String path);

    /**
     * Helper method to convert LocalDate to a MMDDYYYY format for saving to 
     * filenames
     * @param date
     * @return String with date formatted as MMDDYYY
     */
    public default String serializeDate(LocalDate date) {
        String[] tokens = date.toString().split("-");

        // Add leading 0s
        for (String token : tokens) {
            if (token.length() == 1) {
                token = "0" + token;
            }
        }

        return tokens[1] + tokens[2] + tokens[0];
    }

}
