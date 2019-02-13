package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dao.configdao.ConfigDao;
import com.sg.flooringmastery.dao.productsdao.ProductsDao;
import com.sg.flooringmastery.dao.taxesdao.TaxesDao;
import com.sg.flooringmastery.dao.orderdao.OrderDao;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

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
    boolean traininMode;

    public ServiceImpl(ConfigDao configDao, OrderDao ordersDao, ProductsDao productsDao, TaxesDao taxesDao) throws FlooringMasteryDaoFileException {
        this.configDao = configDao;
        this.orderDao = ordersDao;
        this.productsDao = productsDao;
        this.taxesDao = taxesDao;
        taxRates = taxesDao.loadTaxes();
        productList = productsDao.loadProducts();
        ordersForSelectedDate = new ArrayList<>();
    }

    @Override
    public void updateOrder(Order order) throws FlooringMasteryDaoFileException, FlooringMasteryServiceException {
        if (ordersForSelectedDate.isEmpty()) {
            throw new FlooringMasteryServiceException("No orders loaded.");
        } else if (ordersForSelectedDate.size() < order.getOrderNumber()) {
            throw new FlooringMasteryServiceException("Order does not exist.");
        }

        int index = order.getOrderNumber() - 1;
        ordersForSelectedDate.remove(index);
        ordersForSelectedDate.add(index, order);

        saveOrdersByDate();
    }

    @Override
    public void saveNewOrder(Order order) throws FlooringMasteryDaoFileException {
        getOrdersByDate(order.getDate());
        order.setOrderNumber(ordersForSelectedDate.size() + 1);
        ordersForSelectedDate.add(order);
        saveOrdersByDate();
    }

    @Override
    public void saveOrdersByDate() throws FlooringMasteryDaoFileException {
        orderDao.saveOrdersByDate(ordersForSelectedDate);
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
        } else if (ordersForSelectedDate.size() < orderNumber) {
            throw new FlooringMasteryServiceException("Order does not exist.");
        }
        return ordersForSelectedDate.get(orderNumber-1);
    }

    @Override
    public void removeOrder(Order order) throws FlooringMasteryServiceException, FlooringMasteryDaoFileException {
        if (ordersForSelectedDate.isEmpty()) {
            throw new FlooringMasteryServiceException("No orders loaded.");
        } else if (ordersForSelectedDate.size() < order.getOrderNumber()) {
            throw new FlooringMasteryServiceException("Order does not exist.");
        }
        
        ordersForSelectedDate.remove(order.getOrderNumber()-1);
        
        saveOrdersByDate();
    }

    // For testing
    @Override
    public void clearOrderList() {
        ordersForSelectedDate.clear();
    }

}
