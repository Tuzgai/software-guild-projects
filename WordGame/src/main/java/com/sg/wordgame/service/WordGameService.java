package com.sg.wordgame.service;

/**
 *
 * @author Stuart
 */
public interface WordGameService {
    public void addGuess(char letter) throws InvalidGuessException;
    
    public String getGuessesSoFar();
    public String getWordStatus();
    public int getGuessesLeft();
    
    public boolean gameOver();
    public String getWord();
    public boolean isWinner();
}
