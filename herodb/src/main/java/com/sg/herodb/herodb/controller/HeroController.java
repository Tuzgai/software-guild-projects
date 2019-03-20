package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Superhero;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class HeroController {
    @Autowired
    SuperheroDao superheroDao;

    @GetMapping("/heroes")
    public String displayHeroes(Model model) {
        model.addAttribute("isVillainPage", false);
        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        heroes = heroes.stream().filter(h -> !h.isVillain()).collect(Collectors.toList());
        
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
    
    @GetMapping("/villains")
    public String displayVillains(Model model) {
        model.addAttribute("isVillainPage", true);
        List<Superhero> villains = superheroDao.getAllSuperheroes();
        villains = villains.stream().filter(v -> v.isVillain()).collect(Collectors.toList());
        
        model.addAttribute("heroes", villains);
        return "heroes";
    }
}
