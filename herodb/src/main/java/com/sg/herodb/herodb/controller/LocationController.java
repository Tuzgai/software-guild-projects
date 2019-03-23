package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.AddressDao;
import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.dao.SightingDao;
import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Address;
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
public class LocationController {

    @Autowired
    SightingDao sightingDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SuperheroDao superheroDao;

    @Autowired
    AddressDao addressDao;

    @GetMapping("/locations")
    public String displayLocations(Model model) {
        List<Address> addresses = addressDao.getAllAddresses();

        model.addAttribute("address", addresses);
        return "locations";
    }
}
