package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.SightingDao;
import com.sg.herodb.herodb.entity.Sighting;
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
    SightingDao sightingDao;

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
