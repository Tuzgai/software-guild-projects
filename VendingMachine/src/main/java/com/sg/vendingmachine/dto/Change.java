package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author Stuart
 */
public class Change {

    private BigDecimal balance;
    private int quarters, nickels, dimes, pennies;
    
    public Change() {
        this.balance = new BigDecimal("0.00");
        updateCoins();
    }

    public Change(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }

    private void updateCoins() {
        BigDecimal[] arr = balance.divideAndRemainder(new BigDecimal("0.25"));
        quarters = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.10"));
        dimes = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.05"));
        nickels = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.01"));
        pennies = arr[0].intValue();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }

    public int getQuarters() {
        return quarters;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getPennies() {
        return pennies;
    }
}
