package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.dao.PowerDao;
import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Organization;
import com.sg.herodb.herodb.entity.Power;
import com.sg.herodb.herodb.entity.Superhero;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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
public class HeroController {

    @Autowired
    SuperheroDao superheroDao;

    @Autowired
    PowerDao powerDao;

    @Autowired
    OrganizationDao organizationDao;

    @GetMapping("/heroes")
    public String displayHeroes(Model model) {
        model.addAttribute("isVillainPage", false);

        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        heroes = heroes.stream()
                .filter(h -> !h.isVillain())
                .collect(Collectors.toList());

        HashMap<Superhero, List<Organization>> hm = new HashMap<>();

        for (Superhero hero : heroes) {
            hm.put(hero, organizationDao.getOrganizationsByHeroId(hero.getId()));
        }

        model.addAttribute("heroMap", hm);

        return "heroes";
    }

    @GetMapping("/villains")
    public String displayVillains(Model model) {
        model.addAttribute("isVillainPage", true);
        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        heroes = heroes.stream()
                .filter(h -> h.isVillain())
                .collect(Collectors.toList());

        model.addAttribute("heroes", heroes);
        
        HashMap<Superhero, List<Organization>> hm = new HashMap<>();

        for (Superhero hero : heroes) {
            hm.put(hero, organizationDao.getOrganizationsByHeroId(hero.getId()));
        }

        model.addAttribute("heroMap", hm);

        return "heroes";
    }

    @GetMapping("/supers/new")
    public String addSuper(Model model) {
        List<Power> powers = powerDao.getAllPowers();

        model.addAttribute("powers", powers);
        return "addSuper";
    }

    @GetMapping("editSuper")
    public String editSuper(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        List<Power> powers = powerDao.getAllPowers();
        model.addAttribute("powers", powers);

        Superhero hero = superheroDao.getSupeheroById(id);
        model.addAttribute("super", hero);

        return "editSuper";
    }

    @GetMapping("/deleteSuper")
    public String deleteSuper(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        superheroDao.deleteSuperhero(id);

        return "redirect:/heroes";
    }
    
    @GetMapping("/showSuper")
    public String showSuper(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        
        return "super";
    }

    @PostMapping(value = {"/supers/new", "editSuper"})
    public String updateSuper(Superhero hero, HttpServletRequest request) {
        Power power = new Power();
        if (!request.getParameter("powerName").equals("")) {
            power.setName(request.getParameter("powerName"));
            power.setDescription(request.getParameter("powerDescription"));
            power = powerDao.createPower(power);
        } else if(request.getParameter("powerId") == null) {
            power.setId(0);
        } else {
            power.setId(Integer.parseInt(request.getParameter("powerId")));
        }

        hero.setPower(power);
        if (hero.getId() == 0) {
            superheroDao.createSuperhero(hero);
        } else {
            superheroDao.updateSuperhero(hero);
        }

        if (hero.isVillain()) {
            return "redirect:/villains";
        } else {
            return "redirect:/heroes";
        }
    }
}
