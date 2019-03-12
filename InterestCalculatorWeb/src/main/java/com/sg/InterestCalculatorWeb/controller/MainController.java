package com.sg.InterestCalculatorWeb.controller;

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

    final int DAILY = 1;
    final int MONTHLY = 2;
    final int QUARTERLY = 3;
    final int ANNUALLY = 4;
    double interestRate, principal, balance, interestEarned;
    int yearsInFund, numberOfCompounds;
    String compoundRateString;
    ArrayList<Results> results = new ArrayList<>();

    @GetMapping("index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("result")
    public String result(Model model) {
        model.addAttribute("results", results);
        model.addAttribute("principal", principal);
        model.addAttribute("yearsInFund", yearsInFund);
        model.addAttribute("compoundRateString", compoundRateString);
        
        return ("result");
    }

    @PostMapping("formSubmit")
    public String formSubmit(double rate, int years, int frequency, double prin) {
        yearsInFund = years;
        principal = prin;

        switch (frequency) {
            case DAILY:
                compoundRateString = "daily";
                numberOfCompounds = 365;
                break;
            case MONTHLY:
                compoundRateString = "monthly";
                numberOfCompounds = 12;
                break;
            case QUARTERLY:
                compoundRateString = "quarterly";
                numberOfCompounds = 4;
                break;
            default:
                compoundRateString = "annually";
                numberOfCompounds = 1;
        }

        for (int i = 0; i < yearsInFund; i++) {
            for (int j = 0; j < numberOfCompounds; j++) {
                balance *= 1 + (interestRate / 100);
            }
            interestEarned = balance - principal;
            principal = balance;

            results.add(new Results(i, principal, interestEarned, balance));
        }

        return ("result");
    }

    private class Results {

        int year;
        double principal;
        double interestEarned;
        double balance;

        public Results(int year, double principal, double interestEarned, double balance) {
            this.year = year;
            this.principal = principal;
            this.interestEarned = interestEarned;
            this.balance = balance;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getPrincipal() {
            return principal;
        }

        public void setPrincipal(double principal) {
            this.principal = principal;
        }

        public double getInterestEarned() {
            return interestEarned;
        }

        public void setInterestEarned(double interestEarned) {
            this.interestEarned = interestEarned;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

    }

}
