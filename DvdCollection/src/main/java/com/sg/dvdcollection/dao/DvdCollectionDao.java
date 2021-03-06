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
     * @param dvd - DVD object to be added
     * @return the DVD object previously stored if it exists, otherwise null.
     * @throws com.sg.dvdcollection.dao.DvdCollectionDaoException
     */
    DVD addDvd(String title, DVD dvd) throws DvdCollectionDaoException;
    
    /**
     * Returns a List of all DVDs in the collection.
     * @return List of all DVDs in the collection
     * @throws com.sg.dvdcollection.dao.DvdCollectionDaoException
     */
    List<DVD> getAllDvds() throws DvdCollectionDaoException;
    
    /**
     * Returns the DVD objection associated with the title String.
     * @param title - title of DVD to look up
     * @return 
     * @throws com.sg.dvdcollection.dao.DvdCollectionDaoException 
     */
    DVD getDvd(String title) throws DvdCollectionDaoException;
    
    /**
     * Removes a DVD from the collection
     * @param title - title of DVD to be removed
     * @return Removed DVD object or null if DVD not found
     * @throws com.sg.dvdcollection.dao.DvdCollectionDaoException
     */
    DVD removeDvd(String title) throws DvdCollectionDaoException;
}
