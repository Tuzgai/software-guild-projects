package com.sg.wordgame.service;

import com.sg.wordgame.dao.WordGameDao;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class WordGameServiceImpl implements WordGameService {

    WordGameDao dao;
    int guessesLeft;
    char[] word;
    char[] wordStatus;
    List<Character> guessList;
    int correctGuesses;
    boolean winner;

    public WordGameServiceImpl(WordGameDao dao) {
        this.dao = dao;
    }

    @Override
    public void startGame() throws FileNotFoundException {
        guessesLeft = 5;
        word = dao.getWord().toCharArray();
        wordStatus = new char[word.length];
        correctGuesses = 0;
        guessList = new ArrayList<>();
        winner = false;

        for (int i = 0; i < word.length; i++) {
            wordStatus[i] = '_';
        }
    }

    @Override
    public void addGuess(char guess) throws InvalidGuessException {
        guess = Character.toLowerCase(guess);

        if (guessList.contains(guess)) {
            throw new InvalidGuessException(guess + " has already been guessed, try again.");
        } else if (!Character.toString(guess).matches("[a-z]")) {
            throw new InvalidGuessException(guess + " is not a letter, try again.");
        }

        boolean guessedCorrectly = false;
        for (int i = 0; i < word.length; i++) {
            if (guess == word[i]) {
                wordStatus[i] = guess;
                correctGuesses++;
                guessedCorrectly = true;
            }
        }

        guessList.add(guess);
        if (!guessedCorrectly) {
            guessesLeft--;
        }
    }

    @Override
    public String getGuessesSoFar() {
        StringBuilder s = new StringBuilder();

        for (Character item : guessList) {
            s.append(item);
            s.append(" ");
        }

        return s.toString();
    }

    @Override
    public String getWordStatus() {
        return new String(wordStatus);
    }

    @Override
    public int getGuessesLeft() {
        return guessesLeft;
    }

    @Override
    public boolean gameOver() {
        return guessesLeft <= 0 || correctGuesses >= word.length;
    }

    @Override
    public String getWord() {
        return new String(word);
    }

    @Override
    public boolean isWinner() {
        return correctGuesses >= word.length;
    }
}
