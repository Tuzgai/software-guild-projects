package com.sg.flooringmastery.dao.configdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;

/**
 *
 * @author Stuart
 */
public class ConfigDaoStub implements ConfigDao {

    @Override
    public boolean loadTrainingMode() throws FlooringMasteryDaoFileException {
        return false;
    }

    @Override
    public void setPath(String path) {
        // Do nothing
    }
    
}
