package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface DvdCollectionDao {
    /**
     * Adds the given DVD to the roster. If there is already a DVD
     * with the given title it will return that DVD object, otherwise
     * null.
     * 
     * @param title - title of DVD
     * @param dvd - dvd object to be added
     * @return the DVD object previously stored if it exists, otherwise null.
     */
    DVD addDvd(String title, DVD dvd);
    
    /**
     * Returns a List of all DVDs in the collection.
     * @return List of all DVDs in the collection
     */
    List<DVD> getAllDvds();
    
    /**
     * Returns the DVD objection associated with the title String.
     * @param title - title of DVD to look up
     * @return 
     */
    DVD getDvd(String title);
    
    /**
     * Removes a Dvd from the collection
     * @param title - title of DVD to be removed
     * @return Removed DVD object or null if DVD not found
     */
    DVD removeDvd(String title);
}
