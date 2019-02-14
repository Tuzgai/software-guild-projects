package com.sg.flooringmastery.dao.configdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class ConfigDaoFileImpl implements ConfigDao {
    private String path;
    private static final String TRAINING_FILE = "config.txt";
    private static final String DELIMITER = ",";

    public ConfigDaoFileImpl(String path) {
        this.path = path;
    }
    
    @Override
    public boolean loadTrainingMode() throws FlooringMasteryDaoFileException {
        Scanner scn;
        File file = new File(path + TRAINING_FILE);
        try {
            scn = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("Config file not found.");
        }
        
        if(scn.hasNextLine()) {
            String in = scn.nextLine();
            return in.equals("Training");
        }
        
        // Default to training mode
        return true;
    }
    
    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
