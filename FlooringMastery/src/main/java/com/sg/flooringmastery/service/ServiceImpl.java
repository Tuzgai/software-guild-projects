package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dao.configdao.ConfigDao;
import com.sg.flooringmastery.dao.orderdao.FlooringMasteryDaoDataException;
import com.sg.flooringmastery.dao.productsdao.ProductsDao;
import com.sg.flooringmastery.dao.taxesdao.TaxesDao;
import com.sg.flooringmastery.dao.orderdao.OrderDao;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Stuart
 */
public class ServiceImpl implements Service {

    ConfigDao configDao;
    OrderDao orderDao;
    ProductsDao productsDao;
    TaxesDao taxesDao;
    HashMap<String, BigDecimal> taxRates;
    ArrayList<ProductType> productList;
    ArrayList<Order> ordersForSelectedDate;
    boolean trainingMode;

    public ServiceImpl(ConfigDao configDao, OrderDao ordersDao, ProductsDao productsDao, TaxesDao taxesDao) throws FlooringMasteryDaoFileException {
        this.configDao = configDao;
        this.orderDao = ordersDao;
        this.productsDao = productsDao;
        this.taxesDao = taxesDao;
        taxRates = taxesDao.loadTaxes();
        productList = productsDao.loadProducts();
        ordersForSelectedDate = new ArrayList<>();
        trainingMode = configDao.loadTrainingMode();
    }

    @Override
    public void updateOrder(Order order) throws FlooringMasteryDaoFileException, FlooringMasteryServiceException {
        if (ordersForSelectedDate.isEmpty()) {
            throw new FlooringMasteryServiceException("No orders loaded.");
        }

        boolean updateSuccessful = false;
        for (int i = 1; i < ordersForSelectedDate.size(); i++) {
            if (order.getOrderNumber() == ordersForSelectedDate.get(i).getOrderNumber()) {
                ordersForSelectedDate.remove(i);
                ordersForSelectedDate.add(i, order);
                updateSuccessful = true;
                break;
            }
        }
        
        if (updateSuccessful) {
            saveOrdersByDate(order.getDate());
        } else {
            throw new FlooringMasteryServiceException("Order not found.");
        }
    }

    @Override
    public void saveNewOrder(Order order) throws FlooringMasteryDaoFileException {
        try {
            getOrdersByDate(order.getDate());
            order.setOrderNumber(ordersForSelectedDate.get(ordersForSelectedDate.size() - 1).getOrderNumber() + 1);
        } catch (FlooringMasteryDaoFileException e) {
            // If no file exists, our list is empty
            ordersForSelectedDate = new ArrayList<>();
            order.setOrderNumber(1);
        }

        ordersForSelectedDate.add(order);
        saveOrdersByDate(order.getDate());
    }

    @Override
    public void saveOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException {
        try {
            if (!trainingMode) {
                orderDao.saveOrdersByDate(ordersForSelectedDate, date);
            }
        } catch (FlooringMasteryDaoDataException e) {
            // don't save anything
        }
    }

    @Override
    public ArrayList<Order> getOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException {
        ordersForSelectedDate = orderDao.loadOrdersByDate(date);
        return ordersForSelectedDate;
    }

    @Override
    public Order getOrderByNumber(int orderNumber) throws FlooringMasteryServiceException {
        if (ordersForSelectedDate.isEmpty()) {
            throw new FlooringMasteryServiceException("No orders loaded.");
        }

        List<Order> orderList = ordersForSelectedDate.stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .collect(Collectors.toList());

        if (orderList.size() > 0) {
            return orderList.get(0);
        }

        throw new FlooringMasteryServiceException("Order does not exist.");
    }

    @Override
    public void removeOrder(Order order) throws FlooringMasteryServiceException, FlooringMasteryDaoFileException {
        if (ordersForSelectedDate.isEmpty()) {
            throw new FlooringMasteryServiceException("No orders loaded.");
        }

        if (!ordersForSelectedDate.remove(order)) {
            throw new FlooringMasteryServiceException("Order does not exist. No changes were saved.");
        }

        saveOrdersByDate(order.getDate());
    }

    @Override
    public LocalDate getCurrentDate() {
        if (ordersForSelectedDate.isEmpty()) {
            return null;
        } else {
            return ordersForSelectedDate.get(0).getDate();
        }
    }

    public HashMap<String, BigDecimal> getTaxRates() {
        return taxRates;
    }

    public ArrayList<ProductType> getProductList() {
        return productList;
    }
    
    public boolean getTrainingMode() {
        return trainingMode;
    }

    // For testing
    @Override
    public void clearOrderList() {
        ordersForSelectedDate.clear();
    }

}
