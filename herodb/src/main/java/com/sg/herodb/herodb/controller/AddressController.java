package com.sg.herodb.herodb.controller;

import com.sg.herodb.herodb.dao.AddressDao;
import com.sg.herodb.herodb.entity.Address;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class AddressController {

    @Autowired
    AddressDao addressDao;

    @GetMapping("/locations")
    public String displayLocations(Model model) {
        List<Address> addresses = addressDao.getAllAddresses();
        addresses.remove(0); // don't display dummy address

        model.addAttribute("locations", addresses);
        return "locations";
    }

    @GetMapping("/locations/new")
    public String editAddress(Model model) {
        return "addLocation";
    }

    @GetMapping("/editLocation")
    public String updateLocation(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));

        Address address = addressDao.getAddressById(id);
        model.addAttribute("address", address);

        return "editLocation";
    }

    @PostMapping("/editLocation")
    public String updateLocation(@Valid Address location, BindingResult result) {
        if (result.hasErrors()) {
            return "editLocation";
        }

        addressDao.updateAddress(location);
        return "redirect:/locations";
    }

    @PostMapping(value = {"/locations/new"})
    public String createLocation(@Valid Address address, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("address", address);
            return "editLocation";
        }

        addressDao.createAddress(address);

        return "redirect:/locations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        if (id != 1) {
            addressDao.deleteAddress(id);
        }
        return "redirect:/locations";
    }
}
