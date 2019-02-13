package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public interface Service {
    
    /**
     * Updates internal order list and saves changes for that date.
     * Prerequisite: Order list is not empty. 
     * Prerequisite: Specified order exists in file. 
     * @param order
     * @throws FlooringMasteryDaoFileException 
     * @throws com.sg.flooringmastery.service.FlooringMasteryServiceException 
     */
    void updateOrder(Order order) throws FlooringMasteryDaoFileException, FlooringMasteryServiceException;
    
    /**
     * Updates internal order list and saves changes for that date.
     * Path 1: Order list exists
     * Path 2: Order list empty
     * @param order
     * @throws FlooringMasteryDaoFileException 
     */
    void saveNewOrder(Order order) throws FlooringMasteryDaoFileException;
    
    /**
     * Saves internal order list.
     * @throws FlooringMasteryDaoFileException 
     */
    void saveOrdersByDate() throws FlooringMasteryDaoFileException;
    
    /**
     * Loads orders for a given date and returns them.
     * @param date
     * @return
     * @throws FlooringMasteryDaoFileException 
     */
    ArrayList<Order> getOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException;
    
    /**
     * Returned a specified order if present. 
     * Throws FlooringMasteryServiceException if order is not present.
     * @param orderNumber
     * @return 
     * @throws com.sg.flooringmastery.service.FlooringMasteryServiceException 
     */
    Order getOrderByNumber(int orderNumber) throws FlooringMasteryServiceException;
    
    /**
     * Removes an order from internal list and saves.
     * Throws FlooringMasteryServiceException if orders not loaded or order does not exist.
     * @param order
     * @throws FlooringMasteryServiceException 
     */
    void removeOrder(Order order) throws FlooringMasteryServiceException, FlooringMasteryDaoFileException;
    
    /**
     * 
     * @return The date of the currently loaded orders. If none loaded, null.
     */
    LocalDate getCurrentDate();
    
    void clearOrderList();
}
