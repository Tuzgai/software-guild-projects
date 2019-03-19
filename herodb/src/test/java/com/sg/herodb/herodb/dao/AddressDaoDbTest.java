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
public class AddressDaoDbTest {

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

    public AddressDaoDbTest() {
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
            address.setCity("City Unknown");
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
    public void testAddAndGetAddress() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("TestZip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address.setCity("Test city");
        address = addressDao.createAddress(address);

        Address fromDao = addressDao.getAddressById(address.getId());

        assertEquals(address, fromDao);
    }

    @Test
    public void testGetAllAddresses() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address.setCity("Test city");
        address = addressDao.createAddress(address);

        Address address2 = new Address();
        address2.setCountry("Test Country 2");
        address2.setDescription("Test Description 2");
        address2.setLatitude(new BigDecimal("1.000000"));
        address2.setLongitude(new BigDecimal("1.000000"));
        address2.setName("Test Name 2");
        address2.setPostalCode("Test Zip 2");
        address2.setStreetAddress("Test Street Address 2");
        address2.setTerritory("Test Territory 2");
        address2.setCity("Test city 2");
        address2 = addressDao.createAddress(address2);

        List<Address> list = addressDao.getAllAddresses();
        // Don't forget the dummy address
        assertEquals(3, list.size());
        assertTrue(list.contains(address));
        assertTrue(list.contains(address2));
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address.setCity("Test city");
        address = addressDao.createAddress(address);

        Address fromDao = addressDao.getAddressById(address.getId());

        assertEquals(address, fromDao);

        address.setName("Test updated name");
        addressDao.updateAddress(address);

        assertNotEquals(address, fromDao);

        fromDao = addressDao.getAddressById(address.getId());

        assertEquals(address, fromDao);
    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address.setCity("Test city");
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
        sighting.setDescription("Test description");
        sighting = sightingDao.createSighting(sighting);

        Address fromDao = addressDao.getAddressById(address.getId());
        assertEquals(address, fromDao);

        addressDao.deleteAddress(address.getId());
        fromDao = addressDao.getAddressById(address.getId());
        assertNull(fromDao);

        sighting = sightingDao.getSightingById(sighting.getId());
        organization = organizationDao.getOrganizationById(organization.getId());

        assertEquals("Name Unknown", sighting.getAddress().getName());
        assertEquals("Name Unknown", organization.getAddress().getName());
    }
    
    @Test
    public void testGetAddresByHeroId() {
        Address address = new Address();
        address.setCountry("Test Country");
        address.setDescription("Test Description");
        address.setLatitude(new BigDecimal("1.000000"));
        address.setLongitude(new BigDecimal("1.000000"));
        address.setName("Test Name");
        address.setPostalCode("Test Zip");
        address.setStreetAddress("Test Street Address");
        address.setTerritory("Test Territory");
        address.setCity("Test city");
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
        sighting.setDescription("Test description");
        sighting = sightingDao.createSighting(sighting);
        
        List<Address> fromDao = addressDao.getAddressByHeroId(hero.getId());
        assertTrue(fromDao.contains(address));
        
        fromDao = addressDao.getAddressByHeroId(hero2.getId());
        assertFalse(fromDao.contains(address));
    }

}
