package com.sg.wordgame.controller;

import com.sg.wordgame.dao.WordGameDao;
import com.sg.wordgame.service.InvalidGuessException;
import com.sg.wordgame.service.WordGameService;
import com.sg.wordgame.service.WordGameServiceImpl;
import com.sg.wordgame.view.WordGameView;
import java.io.FileNotFoundException;

/**
 *
 * @author Stuart
 */
public class WordGameController {

    WordGameView view;
    WordGameDao dao;
    WordGameService service;

    public WordGameController(WordGameView view, WordGameDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        int choice;
        boolean keepGoing = true;
        this.service = new WordGameServiceImpl(dao);
        
        while (keepGoing) {
            choice = view.displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                default:
                    view.displayExit();
                    keepGoing = false;
            }
        }
    }

    public void playGame() {
        try {
            service.startGame();
        } catch (FileNotFoundException e) {
            view.displayError("Error: could not open words file, please make sure words.txt is present");
        }

        while (!service.gameOver()) {
            view.displayGameStatus(
                    service.getWordStatus(),
                    service.getGuessesSoFar(),
                    service.getGuessesLeft());
            try {
                service.addGuess(view.getGuess());
            } catch (InvalidGuessException e) {
                view.displayError(e.getMessage());
            }
        }

        if (service.isWinner()) {
            view.displayVictoryBanner();
            view.displayGameStatus(
                    service.getWordStatus(),
                    service.getGuessesSoFar(),
                    service.getGuessesLeft());
        } else {
            view.displayLossBanner();
            view.displayGameStatus(
                    service.getWordStatus(),
                    service.getGuessesSoFar(),
                    service.getGuessesLeft());
            view.displayWord(service.getWord());
        }
        view.promptToContinue();
    }
}
