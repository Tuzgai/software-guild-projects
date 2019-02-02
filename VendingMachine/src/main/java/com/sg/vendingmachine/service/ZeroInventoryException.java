package com.sg.vendingmachine.service;

/**
 *
 * @author Stuart
 */
public class ZeroInventoryException extends Exception {

    public ZeroInventoryException(String message) {
        super(message);
    }

    public ZeroInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
