package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.time.LocalDate;
import java.util.List;
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
public class DvdCollectionDaoFileImplTest {

    DvdCollectionDaoFileImpl dao = new DvdCollectionDaoFileImpl();

    public DvdCollectionDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            List<DVD> list = dao.getAllDvds();
            for (DVD item : list) {
                dao.removeDvd(item.getTitle());
            }
        } catch (DvdCollectionDaoException e) {
            fail("Setup failed");
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd and getDvd methods, of class DvdCollectionDaoFileImpl.
     */
    @Test
    public void testAddandRemoveDvd() throws Exception {
        DVD dvd = new DVD("Test");
        dvd.setReleaseDate(LocalDate.of(2019, 1, 1));
        dvd.setRating("R");
        dvd.setStudio("Test Studio");
        dvd.setNote("Notes");
        
        dao.addDvd(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDvd(dvd.getTitle());
        
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDvds method, of class DvdCollectionDaoFileImpl.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        DVD dvd1 = new DVD("Test");
        dvd1.setReleaseDate(LocalDate.of(2019, 1, 1));
        dvd1.setRating("R");
        dvd1.setStudio("Test Studio");
        dvd1.setNote("Notes");
        
        dao.addDvd(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Test - 2");
        dvd2.setReleaseDate(LocalDate.of(1900, 1, 1));
        dvd2.setRating("G");
        dvd2.setStudio("Test Studio 2");
        dvd2.setNote("More Notes");
        
        dao.addDvd(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of removeDvd method, of class DvdCollectionDaoFileImpl.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        DVD dvd1 = new DVD("Test");
        dvd1.setReleaseDate(LocalDate.of(2019, 1, 1));
        dvd1.setRating("R");
        dvd1.setStudio("Test Studio");
        dvd1.setNote("Notes");
        
        dao.addDvd(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Test - 2");
        dvd2.setReleaseDate(LocalDate.of(1900, 1, 1));
        dvd2.setRating("G");
        dvd2.setStudio("Test Studio 2");
        dvd2.setNote("More Notes");
        
        dao.addDvd(dvd2.getTitle(), dvd2);
        
        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd1.getTitle()));
        
        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getTitle()));
    }

}
