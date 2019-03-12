package com.sg.LuckySevens.controller;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class MainController {

    int highRoll = 0;
    int mostMoney = 0;
    int rollCount = 0;
    int startingMoney = 0;
    
    @GetMapping("index")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/result")
    public String resultPage(Model model) {
        model.addAttribute("highRoll", highRoll);
        model.addAttribute("mostMoney", mostMoney);
        model.addAttribute("rollCount", rollCount);
        model.addAttribute("startingMoney", startingMoney);
        
        return "result";
    }
    
    @PostMapping("formSubmit")
    public String formSubmit(int currentMoney) {
        int roll;
        rollCount = 0;
        highRoll = 0;
        mostMoney = 0;
        startingMoney = currentMoney;
        Random rng = new Random();

        do {
            rollCount++;
            roll = rng.nextInt(6) + 1 + rng.nextInt(6) + 1;

            if (roll == 7) {
                currentMoney += 4;
            } else {
                currentMoney -= 1;
            }

            if (currentMoney > mostMoney) {
                highRoll = rollCount;
                mostMoney = currentMoney;
            }
        } while (currentMoney > 0);
        
        return "redirect:/result";
    }
}
