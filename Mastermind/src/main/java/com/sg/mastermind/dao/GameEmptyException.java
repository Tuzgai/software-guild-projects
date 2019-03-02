package com.sg.mastermind.dao;

/**
 *
 * @author Stuart
 */
public class GameEmptyException extends Exception {

    public GameEmptyException(String message) {
        super(message);
    }

    public GameEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
