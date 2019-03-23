package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.AddressDao;
import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.dao.SightingDao;
import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Address;
import com.sg.herodb.herodb.entity.Sighting;
import com.sg.herodb.herodb.entity.Superhero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class SightingController {

    @Autowired
    SightingDao sightingDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SuperheroDao superheroDao;

    @Autowired
    AddressDao addressDao;

    
    @GetMapping("/sightings")
    public String displayRecentSightings(Model model) {
        // Get 10 most recent sightings
        List<Sighting> sightings = sightingDao.getAllSightings();

        model.addAttribute("sightings", sightings);
        return "sightings";
    }

    @GetMapping("/editSighting")
    public String editSighting(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Sighting sighting = sightingDao.getSightingById(id);
        model.addAttribute("sighting", sighting);

        List<Address> addresses = addressDao.getAllAddresses();
        model.addAttribute("addresses", addresses);

        List<Superhero> heroes = superheroDao.getHeroesNotInSighting(id);
        model.addAttribute("heroes", heroes);

        return "editSighting";
    }
    
    @GetMapping("/sightings/new")
    public String addOrganization(Model model) {
        List<Address> addresses = addressDao.getAllAddresses();
        model.addAttribute("addresses", addresses);

        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        model.addAttribute("heroes", heroes);

        return "addSighting";
    }
    
    @GetMapping("/deleteSighting")
    public String deleteOrganization(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        sightingDao.deleteSighting(id);

        return "redirect:/sightings";
    }
    
    @PostMapping(value = {"/sightings/new", "editSighting"})
    public String updateOrganization(Sighting sighting, HttpServletRequest request) {
        sighting.setAddress(addressDao.getAddressById(
                Integer.parseInt(request.getParameter("addressid"))));

        sighting.setDate(LocalDate.parse(request.getParameter("sightingDate")));
        String[] heroIds = request.getParameterValues("selectedHeroes");

        List<Superhero> heroes = new ArrayList<>();
        if (heroIds != null) {
            for (String id : heroIds) {
                heroes.add(superheroDao.getSupeheroById(Integer.parseInt(id)));
            }
        }

        sighting.setHeroes(heroes);
        sightingDao.updateSighting(sighting);

        return "redirect:/sightings";
    }
}
