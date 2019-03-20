package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.OrganizationDao;
import com.sg.herodb.herodb.entity.Organization;
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
public class OrganizationController {
    @Autowired
    OrganizationDao organizationDao;
    
    @GetMapping("/organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.getAllOrganizations();
        
        model.addAttribute("organizations", organizations);
        
        return "organizations";
    }
    
}
