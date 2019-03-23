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
