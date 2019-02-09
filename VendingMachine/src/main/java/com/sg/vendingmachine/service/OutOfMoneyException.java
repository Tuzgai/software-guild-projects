package com.sg.vendingmachine.service;

/**
 *
 * @author Stuart
 */
public class OutOfMoneyException extends Exception {

    public OutOfMoneyException(String message) {
        super(message);
    }

    public OutOfMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
