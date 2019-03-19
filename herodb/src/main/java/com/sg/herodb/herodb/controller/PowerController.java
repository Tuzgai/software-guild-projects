package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.PowerDao;
import com.sg.herodb.herodb.entity.Power;
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
public class PowerController {
    @Autowired
    PowerDao powerDao;
    
    @GetMapping("/powers")
    public String showPowers(Model model) {
        List<Power> powers = powerDao.getAllPowers();
        model.addAttribute("powers", powers);
        return "powers";
    }
}
