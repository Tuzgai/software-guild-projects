package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.AddressDao;
import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.dao.PowerDao;
import com.sg.herodb.herodb.dao.SightingDao;
import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Address;
import com.sg.herodb.herodb.entity.Organization;
import com.sg.herodb.herodb.entity.Power;
import com.sg.herodb.herodb.entity.Sighting;
import com.sg.herodb.herodb.entity.Superhero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class IndexController {

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

    @GetMapping("/")
    public String displayRecentSightings(Model model) {
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
        sighting.setDescription("Test sighting");
        sighting = sightingDao.createSighting(sighting);
        

        // Get 10 most recent sightings
        List<Sighting> sightings = sightingDao.getAllSightings();
        Collections.sort(sightings);

        if (sightings.size() > 10) {
            sightings = sightings.subList(0, 10);
        }
        
        model.addAttribute("sightings", sightings);
        return "index";
    }
}
