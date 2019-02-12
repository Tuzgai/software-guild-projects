package com.sg.flooringmastery.dao.productsdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.ProductType;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public interface ProductsDao {

    public ArrayList<ProductType> loadProducts() throws FlooringMasteryDaoFileException;

    void setPath(String path);
}
