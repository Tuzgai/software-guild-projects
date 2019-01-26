package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class DvdCollectionDaoFileImpl implements DvdCollectionDao{
    private Map<String, DVD> dvdCollection = new HashMap<>();
    public static final String COLLECTION_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public DVD addDvd(String title, DVD dvd) throws DvdCollectionDaoException {
        DVD newDvd = dvdCollection.put(title, dvd);
        writeDvdCollection();
        return newDvd;
    }

    @Override
    public List<DVD> getAllDvds() throws DvdCollectionDaoException {
        loadDvdCollection();
        return new ArrayList<DVD>(dvdCollection.values());
    }

    @Override
    public DVD getDvd(String title) throws DvdCollectionDaoException {
        loadDvdCollection();
        return dvdCollection.get(title);
    }

    @Override
    public DVD removeDvd(String title) throws DvdCollectionDaoException {
        DVD dvd = dvdCollection.remove(title);
        writeDvdCollection();
        return dvd;
    }
    
    private void loadDvdCollection() throws DvdCollectionDaoException {
        Scanner scn;
        
        try {
            scn = new Scanner(new File(COLLECTION_FILE));
        } catch (FileNotFoundException e) {
            throw new DvdCollectionDaoException("-_- Could not load collection file into memory.", e);
        }
        
        String currentLine;
        
        String[] currentTokens;
        
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            DVD newDVD = new DVD(currentTokens[0]);
            newDVD.setReleaseDate(LocalDate.ofEpochDay(Long.parseLong(currentTokens[1])));
            newDVD.setRating(currentTokens[2]);
            newDVD.setStudio(currentTokens[3]);
            newDVD.setNote(currentTokens[4]);
            
            dvdCollection.put(newDVD.getTitle(), newDVD);
        }
        scn.close();
    }
    
    private void writeDvdCollection() throws DvdCollectionDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
        } catch (IOException e) {
            throw new DvdCollectionDaoException("Could not save collection data.", e);
        }
        
        List<DVD> dvdList = this.getAllDvds();
        for(DVD dvd : dvdList) {
            out.println(dvd.getTitle() + DELIMITER +
                    dvd.getReleaseDate().toEpochDay() + DELIMITER +
                    dvd.getRating() + DELIMITER +
                    dvd.getStudio() + DELIMITER +
                    dvd.getNote());
            out.flush();
        }
        out.close();
    }
}
