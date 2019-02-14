package com.sg.flooringmastery.dao.orderdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public class OrderDaoStub implements OrderDao {
    
    // Make one order and return it
    @Override
    public ArrayList<Order> loadOrdersByDate(LocalDate date) throws FlooringMasteryDaoFileException {

        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        LocalDate testDate = LocalDate.of(1997, 1, 30);

        if (!date.equals(testDate)) {
            throw new FlooringMasteryDaoFileException("No file for this date.");
        }

        Order order = new Order();
        order.setDate(testDate);
        order.setOrderNumber(1);
        order.setCustName("Test Cust");
        order.setState("MN");
        order.setTaxRate(new BigDecimal("1.00"));
        order.setProductType(product);
        order.setAreaSquareFeet(new BigDecimal("1.00"));
        order.setMaterialCost(new BigDecimal("1.00"));
        order.setLaborCost(new BigDecimal("1.00"));
        order.setTaxPaid(new BigDecimal("1.00"));
        order.setTotal(new BigDecimal("1.00"));

        Order order2 = new Order();
        order2.setDate(testDate);
        order2.setOrderNumber(2);
        order2.setCustName("Test Cust 2");
        order2.setState("MN");
        order2.setTaxRate(new BigDecimal("2.00"));
        order2.setProductType(product);
        order2.setAreaSquareFeet(new BigDecimal("2.00"));
        order2.setMaterialCost(new BigDecimal("2.00"));
        order2.setLaborCost(new BigDecimal("2.00"));
        order2.setTaxPaid(new BigDecimal("2.00"));
        order2.setTotal(new BigDecimal("2.00"));

        ArrayList<Order> list = new ArrayList<>();
        list.add(order);
        list.add(order2);
        
        return list;

    }

    @Override
    public void saveOrdersByDate(ArrayList<Order> orders, LocalDate date) throws FlooringMasteryDaoFileException {
        // do nothing
    }

    @Override
    public void setPath(String path) {
        // Do nothing
    }
}
