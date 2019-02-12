package com.sg.flooringmastery.dao.configdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;

/**
 *
 * @author Stuart
 */
public interface ConfigDao {
    boolean loadTrainingMode() throws FlooringMasteryDaoFileException;
    
    void setPath(String path);
}
