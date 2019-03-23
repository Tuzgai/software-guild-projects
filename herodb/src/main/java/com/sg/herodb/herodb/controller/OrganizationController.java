package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.AddressDao;
import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.dao.SuperheroDao;
import com.sg.herodb.herodb.entity.Address;
import com.sg.herodb.herodb.entity.Organization;
import com.sg.herodb.herodb.entity.Superhero;
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
public class OrganizationController {

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SuperheroDao superheroDao;

    @Autowired
    AddressDao addressDao;

    @GetMapping("/organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.getAllOrganizations();

        model.addAttribute("organizations", organizations);

        return "organizations";
    }

    @GetMapping("/editOrganization")
    public String editOrganization(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Organization organization = organizationDao.getOrganizationById(id);
        model.addAttribute("organization", organization);

        List<Address> addresses = addressDao.getAllAddresses();
        model.addAttribute("addresses", addresses);

        List<Superhero> heroes = superheroDao.getHeroesNotInOrganization(id);
        model.addAttribute("heroes", heroes);

        return "editOrganization";
    }

    @GetMapping("/organizations/new")
    public String addOrganization(Model model) {
        List<Address> addresses = addressDao.getAllAddresses();
        model.addAttribute("addresses", addresses);

        List<Superhero> heroes = superheroDao.getAllSuperheroes();
        model.addAttribute("heroes", heroes);

        return "addOrganization";
    }

    @GetMapping("/deleteOrganization")
    public String deleteOrganization(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        organizationDao.deleteOrganization(id);

        return "redirect:/organizations";
    }

    @PostMapping(value = {"editOrganization", "/organizations/new"})
    public String updateOrganization(Organization organization, HttpServletRequest request) {
        organization.setAddress(addressDao.getAddressById(
                Integer.parseInt(request.getParameter("addressid"))));

        String[] heroIds = request.getParameterValues("selectedHeroes");

        List<Superhero> heroes = new ArrayList<>();
        if (heroIds != null) {
            for (String id : heroIds) {
                heroes.add(superheroDao.getSupeheroById(Integer.parseInt(id)));
            }
        }

        organization.setHeroes(heroes);
        if (organization.getId() == 0) {
            organizationDao.createOrganization(organization);
        } else {
            organizationDao.updateOrganization(organization);
        }
        return "redirect:/organizations";
    }
}
