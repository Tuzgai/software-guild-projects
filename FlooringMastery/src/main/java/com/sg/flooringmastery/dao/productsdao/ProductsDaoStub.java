package com.sg.flooringmastery.dao.productsdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public class ProductsDaoStub implements ProductsDao {
    
    // Return a list of one product
    @Override
    public ArrayList<ProductType> loadProducts() {
        ProductType product = new ProductType("TestProduct", new BigDecimal("5.00"), new BigDecimal("10.00"));
        ArrayList<ProductType> list = new ArrayList<>();
        list.add(product);
        return list;
    }

    @Override
    public void setPath(String path) {
        // Do nothing
    }

}
