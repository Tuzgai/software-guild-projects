package com.sg.vendingmachine.service;

/**
 *
 * @author Stuart
 */
public class OutOfCoinsException extends Exception {

    public OutOfCoinsException(String message) {
        super(message);
    }

    public OutOfCoinsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
