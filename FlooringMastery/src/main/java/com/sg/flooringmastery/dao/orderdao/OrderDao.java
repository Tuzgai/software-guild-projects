package com.sg.flooringmastery.dao.orderdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public interface OrderDao {

    public ArrayList<Order> loadOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException;

    public void saveOrdersByDate(ArrayList<Order> orders) throws FlooringMasteryDaoFileException, FlooringMasteryDaoDataException;
    
    void setPath(String path);
    
    /**
     * Helper method to convert LocalDate to a MMDDYYYY format for saving to
     * filenames
     *
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
