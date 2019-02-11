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
    public HashMap<String, Integer> loadTaxes();
    
    public ArrayList<ProductType> loadProducts();
    
    public ArrayList<Order> loadOrdersByDate(LocalDate date);
    
    boolean loadTrainingMode();
    
    void saveOrder(Order order);
    
    void updateOrder(Order order);
    
    void setPath(String path);
}
