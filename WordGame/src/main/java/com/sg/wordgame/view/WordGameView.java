package com.sg.wordgame.view;

/**
 *
 * @author Stuart
 */
public class WordGameView {
    UserIO io;

    public WordGameView(UserIO io) {
        this.io = io;
    }
    
    public void displayError(String e) {
        io.println("");
        io.println(e);
    }
    
    public int displayMenuAndGetChoice() {
        io.println("Let's play a guessing game!");
        io.println("1. New Game");
        io.println("2. Exit Program");
        return io.readInt("Enter your choice: ");
    }
    
    public void displayExit() {
        io.println("Thanks for playing! Exiting...");
    }
    
    public char getGuess() {
        return io.readChar("Enter your guess: ");
    }
    
    public void displayVictoryBanner() {
        io.println("");
        io.println("=== YOU WIN!!! ===");
    }
    
    public void displayLossBanner()  {
        io.println("");
        io.println("=== Better luck next time! ===");
    }
    
    public void displayWord(String word) {
        io.println("The word was: " + word);
    }
    
    public void promptToContinue() {
        io.readString("Press enter to continue.");
    }
    
    public void displayGameStatus(String wordStatus, String guessesSoFar, int guessesLeft) {
        io.println("");
        io.println("Word so far: " + wordStatus);
        io.println("Your guesses so far: " + guessesSoFar);
        io.println("Guesses left: " + guessesLeft);
    }
}
