package com.sg.flooringmastery.dao.configdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class ConfigDaoFileImpl implements ConfigDao {
    private String path;
    private static final String TRAINING_FILE = "trainingMode.txt";
    private static final String DELIMITER = ",";

    public ConfigDaoFileImpl(String path) {
        this.path = path;
    }
    
    @Override
    public boolean loadTrainingMode() throws FlooringMasteryDaoFileException {
        Scanner scn;
        File file = new File(path + TRAINING_FILE);

        // If there's a file there, we are in training mode.
        return file.exists();
    }
    
    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
