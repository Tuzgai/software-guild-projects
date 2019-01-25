package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stuart
 */
public class DvdCollectionDaoFileImpl implements DvdCollectionDao{
    private Map<String, DVD> dvdCollection = new HashMap<>();
    
    @Override
    public DVD addDvd(String title, DVD dvd) {
        DVD newDvd = dvdCollection.put(title, dvd);
        return newDvd;
    }

    @Override
    public List<DVD> getAllDvds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD removeDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD editDvd(String title, DVD dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
