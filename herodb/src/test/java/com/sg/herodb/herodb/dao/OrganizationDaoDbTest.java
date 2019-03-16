package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Address;
import com.sg.herodb.herodb.entity.Organization;
import com.sg.herodb.herodb.entity.Power;
import com.sg.herodb.herodb.entity.Sighting;
import com.sg.herodb.herodb.entity.Superhero;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Stuart
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationDaoDbTest {
    
    @Autowired
    AddressDao addressDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    PowerDao powerDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperheroDao superheroDao;
    
    public OrganizationDaoDbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Clear out all daos before any tests
        List<Address> addresses = addressDao.getAllAddresses();
        addresses.forEach(a -> addressDao.deleteAddress(a.getId()));
        
        List<Organization> orgs = organizationDao.getAllOrganizations();
        orgs.forEach(o -> organizationDao.deleteOrganization(o.getId()));
        
        List<Power> powers = powerDao.getAllPowers();
        powers.forEach(p -> powerDao.deletePower(p.getId()));
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        powers.forEach(s -> sightingDao.deleteSighting(s.getId()));
        
        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        heroes.forEach(h -> superheroDao.deleteSuperhero(h.getId()));
    }
    
    @After
    public void tearDown() {
    }

    
}
