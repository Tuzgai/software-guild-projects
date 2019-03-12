package com.sg.factorizer.controller;

import java.util.ArrayList;
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
    int n = 0;
    
    @PostMapping("formSubmit")
    public String formSubmit(int number) {
        n = number;
        return "redirect:/result";
    }
     
    @GetMapping("index")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("result")
    public String resultPage(Model model) {
        model.addAttribute("number", n);
        model.addAttribute("isPrime", isPrime(n));
        model.addAttribute("isPerfect", isPerfect(n));
        model.addAttribute("factors", factors(n));
        
        return "result";
    }
    
    public boolean isPerfect(int n) {
        int sum = String.valueOf(n).chars().map(Character::getNumericValue).sum();
        
        return sum == n;
    }
    
    public boolean isPrime(int n) {
        if(n == 0 || n == 1) {
            return false;
        }
        
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    public ArrayList<Integer> factors(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 2; i < n/2; i++) {
            if(n % i == 0 && isPrime(i)){
                arr.add(i);
            }
        }
        return arr;
    }
}
