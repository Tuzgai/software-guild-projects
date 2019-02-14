package com.sg.flooringmastery.dao.configdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
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
public class ConfigDaoFileImplTest {
    ConfigDaoFileImpl instance = new ConfigDaoFileImpl("./testing/");
    
    public ConfigDaoFileImplTest() {
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
    public void testLoadTrainingMode() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/");
        assertFalse(instance.loadTrainingMode());
    }

    public void testLoadTrainingModeNoFile() throws FlooringMasteryDaoFileException {
        instance.setPath("./testing/training/");
        assertTrue(instance.loadTrainingMode());
    }
    
}
