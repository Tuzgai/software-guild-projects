package com.sg.wordgame.service;

import java.io.FileNotFoundException;

/**
 *
 * @author Stuart
 */
public interface WordGameService {
    public void addGuess(char letter) throws InvalidGuessException;
    public void startGame() throws FileNotFoundException;
    public String getGuessesSoFar();
    public String getWordStatus();
    public int getGuessesLeft();
    
    public boolean gameOver();
    public String getWord();
    public boolean isWinner();
}
