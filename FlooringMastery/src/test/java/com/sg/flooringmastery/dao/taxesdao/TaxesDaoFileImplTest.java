package com.sg.flooringmastery.dao.taxesdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import java.util.HashMap;
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
public class TaxesDaoFileImplTest {
    TaxesDaoFileImpl instance = new TaxesDaoFileImpl("/testing/");
    public TaxesDaoFileImplTest() {
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
    public void testLoadTaxes() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/");
        HashMap map = instance.loadTaxes();
        assertTrue(map.size() == 4);
    }

    @Test(expected = FlooringMasteryDaoFileException.class)
    public void testLoadTaxesNoFile() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/emptyDir/");
        instance.loadTaxes();
    }
    
}
