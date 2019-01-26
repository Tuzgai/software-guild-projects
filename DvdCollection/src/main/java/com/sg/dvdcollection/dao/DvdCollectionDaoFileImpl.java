package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.util.ArrayList;
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
        return new ArrayList<DVD>(dvdCollection.values());
    }

    @Override
    public DVD getDvd(String title) {
        return dvdCollection.get(title);
    }

    @Override
    public DVD removeDvd(String title) {
        return dvdCollection.remove(title);
    }
}
