package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.configdao.ConfigDao;
import com.sg.flooringmastery.dao.orderdao.OrdersDao;
import com.sg.flooringmastery.dao.productsdao.ProductsDao;
import com.sg.flooringmastery.dao.taxesdao.TaxesDao;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryServiceImpl {
    ConfigDao configDao;
    OrdersDao ordersDao;
    ProductsDao productsDao;
    TaxesDao taxesDao;

    public FlooringMasteryServiceImpl(ConfigDao configDao, OrdersDao ordersDao, ProductsDao productsDao, TaxesDao taxesDao) {
        this.configDao = configDao;
        this.ordersDao = ordersDao;
        this.productsDao = productsDao;
        this.taxesDao = taxesDao;
    }
}
