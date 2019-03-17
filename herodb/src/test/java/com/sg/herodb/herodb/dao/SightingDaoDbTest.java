package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Address;
import com.sg.herodb.herodb.entity.Organization;
import com.sg.herodb.herodb.entity.Power;
import com.sg.herodb.herodb.entity.Sighting;
import com.sg.herodb.herodb.entity.Superhero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
public class SightingDaoDbTest {

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

    public SightingDaoDbTest() {
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
        sightings.forEach(s -> sightingDao.deleteSighting(s.getId()));

        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        heroes.forEach(h -> superheroDao.deleteSuperhero(h.getId()));

        // Add back the two dummy 'unknown' items after DB reset
        if (addressDao.getAddressById(1) == null) {
            Address address = new Address();
            address.setCountry("Country Unknown");
            address.setDescription("No Description");
            address.setLatitude(new BigDecimal("1.000000"));
            address.setLongitude(new BigDecimal("1.000000"));
            address.setName("Name Unknown");
            address.setPostalCode("ZipUnknown");
            address.setStreetAddress("Street Address Unknown");
            address.setTerritory("Territory Unknown");
            addressDao.createAddress(address);
        }

        if (powerDao.getPowerById(1) == null) {
            Power power = new Power();
            power.setDescription("No description");
            power.setName("Power unknown");
            powerDao.createPower(power);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGetSighting() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address = addressDao.createAddress(address);

        Power power = new Power();
        power.setDescription("Test power description");
        power.setName("Test power");
        power = powerDao.createPower(power);

        Power power2 = new Power();
        power2.setDescription("Test power description 2");
        power2.setName("Test power 2");
        power2 = powerDao.createPower(power2);

        Superhero hero = new Superhero();
        hero.setDescription("Test hero description 1");
        hero.setIsVillain(true);
        hero.setName("Test hero 1");
        hero.setPower(power);
        hero = superheroDao.createSuperhero(hero);

        Superhero hero2 = new Superhero();
        hero2.setDescription("Test hero description 2");
        hero2.setIsVillain(false);
        hero2.setName("Test hero 2");
        hero2.setPower(power2);
        hero2 = superheroDao.createSuperhero(hero2);

        List<Superhero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero2);

        Organization organization = new Organization();
        organization.setDescription("Test org description");
        organization.setName("Test org");
        organization.setAddress(address);
        organization.setHeroes(heroes);
        organization = organizationDao.createOrganization(organization);

        Sighting sighting = new Sighting();
        sighting.setAddress(address);
        sighting.setDate(LocalDate.of(2018, Month.MARCH, 5));
        sighting.setHeroes(heroes);
        sighting = sightingDao.createSighting(sighting);
        
        Sighting fromDao = sightingDao.getSightingById(sighting.getId());
        
        assertEquals(sighting, fromDao);
    }
    
    @Test
    public void testGetAllSightings() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address = addressDao.createAddress(address);

        Power power = new Power();
        power.setDescription("Test power description");
        power.setName("Test power");
        power = powerDao.createPower(power);

        Power power2 = new Power();
        power2.setDescription("Test power description 2");
        power2.setName("Test power 2");
        power2 = powerDao.createPower(power2);

        Superhero hero = new Superhero();
        hero.setDescription("Test hero description 1");
        hero.setIsVillain(true);
        hero.setName("Test hero 1");
        hero.setPower(power);
        hero = superheroDao.createSuperhero(hero);

        Superhero hero2 = new Superhero();
        hero2.setDescription("Test hero description 2");
        hero2.setIsVillain(false);
        hero2.setName("Test hero 2");
        hero2.setPower(power2);
        hero2 = superheroDao.createSuperhero(hero2);

        List<Superhero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero2);

        Organization organization = new Organization();
        organization.setDescription("Test org description");
        organization.setName("Test org");
        organization.setAddress(address);
        organization.setHeroes(heroes);
        organization = organizationDao.createOrganization(organization);

        Sighting sighting = new Sighting();
        sighting.setAddress(address);
        sighting.setDate(LocalDate.of(2018, Month.MARCH, 5));
        sighting.setHeroes(heroes);
        sighting = sightingDao.createSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setAddress(address);
        sighting2.setDate(LocalDate.of(2022, Month.DECEMBER, 20)); // new date
        sighting2.setHeroes(heroes);
        sighting2 = sightingDao.createSighting(sighting2);
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));
    }
    
    @Test
    public void testUpdateSighting() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address = addressDao.createAddress(address);

        Power power = new Power();
        power.setDescription("Test power description");
        power.setName("Test power");
        power = powerDao.createPower(power);

        Power power2 = new Power();
        power2.setDescription("Test power description 2");
        power2.setName("Test power 2");
        power2 = powerDao.createPower(power2);

        Superhero hero = new Superhero();
        hero.setDescription("Test hero description 1");
        hero.setIsVillain(true);
        hero.setName("Test hero 1");
        hero.setPower(power);
        hero = superheroDao.createSuperhero(hero);

        Superhero hero2 = new Superhero();
        hero2.setDescription("Test hero description 2");
        hero2.setIsVillain(false);
        hero2.setName("Test hero 2");
        hero2.setPower(power2);
        hero2 = superheroDao.createSuperhero(hero2);

        List<Superhero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero2);

        Organization organization = new Organization();
        organization.setDescription("Test org description");
        organization.setName("Test org");
        organization.setAddress(address);
        organization.setHeroes(heroes);
        organization = organizationDao.createOrganization(organization);

        Sighting sighting = new Sighting();
        sighting.setAddress(address);
        sighting.setDate(LocalDate.of(2018, Month.MARCH, 5));
        sighting.setHeroes(heroes);
        sighting = sightingDao.createSighting(sighting);
        
        Sighting fromDao = sightingDao.getSightingById(sighting.getId()); 
        assertEquals(sighting, fromDao);
        
        sighting.setDate(LocalDate.of(2019, Month.MARCH, 5));
        sightingDao.updateSighting(sighting);
        
        assertNotEquals(sighting, fromDao);
        
        fromDao = sightingDao.getSightingById(sighting.getId());
        
        assertEquals(sighting, fromDao);
    }
    
    @Test
    public void testDeleteSighting() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address = addressDao.createAddress(address);

        Power power = new Power();
        power.setDescription("Test power description");
        power.setName("Test power");
        power = powerDao.createPower(power);

        Power power2 = new Power();
        power2.setDescription("Test power description 2");
        power2.setName("Test power 2");
        power2 = powerDao.createPower(power2);

        Superhero hero = new Superhero();
        hero.setDescription("Test hero description 1");
        hero.setIsVillain(true);
        hero.setName("Test hero 1");
        hero.setPower(power);
        hero = superheroDao.createSuperhero(hero);

        Superhero hero2 = new Superhero();
        hero2.setDescription("Test hero description 2");
        hero2.setIsVillain(false);
        hero2.setName("Test hero 2");
        hero2.setPower(power2);
        hero2 = superheroDao.createSuperhero(hero2);

        List<Superhero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero2);

        Organization organization = new Organization();
        organization.setDescription("Test org description");
        organization.setName("Test org");
        organization.setAddress(address);
        organization.setHeroes(heroes);
        organization = organizationDao.createOrganization(organization);

        Sighting sighting = new Sighting();
        sighting.setAddress(address);
        sighting.setDate(LocalDate.of(2018, Month.MARCH, 5));
        sighting.setHeroes(heroes);
        sighting = sightingDao.createSighting(sighting);
        
        Sighting fromDao = sightingDao.getSightingById(sighting.getId());
        assertEquals(sighting, fromDao);
        
        sightingDao.deleteSighting(sighting.getId());
        fromDao = sightingDao.getSightingById(sighting.getId());
        assertNull(fromDao);
    }
    
    @Test
    public void testGetSightingsByDate() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address = addressDao.createAddress(address);

        Power power = new Power();
        power.setDescription("Test power description");
        power.setName("Test power");
        power = powerDao.createPower(power);

        Power power2 = new Power();
        power2.setDescription("Test power description 2");
        power2.setName("Test power 2");
        power2 = powerDao.createPower(power2);

        Superhero hero = new Superhero();
        hero.setDescription("Test hero description 1");
        hero.setIsVillain(true);
        hero.setName("Test hero 1");
        hero.setPower(power);
        hero = superheroDao.createSuperhero(hero);

        Superhero hero2 = new Superhero();
        hero2.setDescription("Test hero description 2");
        hero2.setIsVillain(false);
        hero2.setName("Test hero 2");
        hero2.setPower(power2);
        hero2 = superheroDao.createSuperhero(hero2);

        List<Superhero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero2);

        Organization organization = new Organization();
        organization.setDescription("Test org description");
        organization.setName("Test org");
        organization.setAddress(address);
        organization.setHeroes(heroes);
        organization = organizationDao.createOrganization(organization);

        Sighting sighting = new Sighting();
        sighting.setAddress(address);
        sighting.setDate(LocalDate.of(2018, Month.MARCH, 5));
        sighting.setHeroes(heroes);
        sighting = sightingDao.createSighting(sighting);
        
        List<Sighting> sightings = sightingDao.getSightingsByDate(LocalDate.of(2018, Month.MARCH, 5));
        assertTrue(sightings.contains(sighting));
        
        sightings = sightingDao.getSightingsByDate(LocalDate.of(2018, Month.MARCH, 6));
        assertFalse(sightings.contains(sighting));
    }
}
