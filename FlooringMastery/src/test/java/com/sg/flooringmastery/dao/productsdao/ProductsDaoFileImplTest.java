package com.sg.flooringmastery.dao.productsdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.ProductType;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
public class ProductsDaoFileImplTest {
    ProductsDaoFileImpl instance = new ProductsDaoFileImpl("/testing/");
    
    public ProductsDaoFileImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoadProducts() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/");
        ArrayList<ProductType> list = instance.loadProducts();
        assertTrue(list.size() == 4);
    }
    
    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadProductsNoFile() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/emptyDir/");
        ArrayList<ProductType> list = instance.loadProducts();
    }
    
}
