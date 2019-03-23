package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.PowerDao;
import com.sg.herodb.herodb.entity.Power;
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
public class PowerController {

    @Autowired
    PowerDao powerDao;

    @GetMapping("/powers")
    public String showPowers(Model model) {
        List<Power> powers = powerDao.getAllPowers();
        powers.remove(0); // Don't display the dummy power
        model.addAttribute("powers", powers);

        return "powers";
    }

    @GetMapping("/powers/new")
    public String addPower(Model model) {
        return "addPower";
    }

    @GetMapping("/editPower")
    public String editPower(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Power power = powerDao.getPowerById(id);
        model.addAttribute("power", power);

        return "editPower";
    }

    @PostMapping(value = {"/editPower", "/powers/new"})
    public String updatePower(Power power) {
        if (power.getId() == 0) {
            powerDao.createPower(power);
        } else {
            powerDao.updatePower(power);
        }

        return "redirect:/powers";
    }

    @GetMapping("/deletePower")
    public String deleteOrganization(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        if (id != 1) {
            powerDao.deletePower(id);
        }
        return "redirect:/powers";
    }

}
