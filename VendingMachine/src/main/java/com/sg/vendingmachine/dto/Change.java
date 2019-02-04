package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Stuart
 */
public class Change {

    private BigDecimal balance;
    private int quarters, nickels, dimes, pennies;
    private final MathContext mc;
    
    public Change() {
        this.mc = new MathContext(2, RoundingMode.HALF_UP);
        this.balance = new BigDecimal("0.0", mc);
        updateCoins();
    }

    public Change(BigDecimal balance) {
        this.mc = new MathContext(3, RoundingMode.HALF_UP);
        this.balance = balance;
        updateCoins();
    }

    private void updateCoins() {
        BigDecimal[] arr = balance.divideAndRemainder(new BigDecimal("0.25", mc));
        quarters = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.10", mc));
        dimes = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.05", mc));
        nickels = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.01", mc));
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
