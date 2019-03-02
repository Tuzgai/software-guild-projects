package com.sg.mastermind.dao.service;

import com.sg.mastermind.dao.MastermindGameDao;
import com.sg.mastermind.dao.MastermindRoundDao;
import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Stuart
 */
@Component
public class MastermindService {

    final int GAME_SIZE = 4;
    @Autowired
    MastermindGameDao gameDao;

    @Autowired
    MastermindRoundDao roundDao;

    public Game startNewGame() {
        Game game = new Game();
        ArrayList<Character> a
                = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        Collections.shuffle(a);

        // generate solution - 4 digits, no repeats
        ArrayList<Character> solution = new ArrayList<>(Arrays.asList(a.get(0),
                a.get(1),
                a.get(2),
                a.get(3)));

        game.setSolution(solution);
        return gameDao.createGame(game);
    }

    public Round makeGuess(ArrayList<Character> guess, int gameId) {
        Round round = new Round();
        Game game = gameDao.getGameById(gameId);
        ArrayList<Character> solution = game.getSolution();
        HashSet<Character> hs = new HashSet<>();
        int e = 0, p = 0;

        for (int i = 0; i < solution.size(); i++) {
            if (guess.get(i).equals(solution.get(i))) {
                e++;
            }
            hs.add(guess.get(i));
            hs.add(solution.get(i));
        }   

        // If no guesses are correct, both lists will be present in hs
        // Solution.length*2 instead of 8 in case we want to change the length
        // Exact is not partial, so subtract them
        p = (solution.size() * 2) - hs.size() - e;

        round.setExactMatches(e);
        round.setPartialMatches(p);
        round.setGameId(gameId);
        roundDao.createRound(round);

        if (e == GAME_SIZE) {
            gameDao.endGame(game);
        }
        return round;
    }

    public List<Game> getAllGamesForDisplay() {
        List<Game> gameList = gameDao.getAllGames();
        ArrayList<Character> placeholder = new ArrayList<>();

        gameList.stream()
                .forEach(g -> {
                    if (!g.isComplete()) {
                        g.setSolution(placeholder);
                    }
                });

        gameList.sort(new SortById());
        return gameList;
    }

    public Game getGameByIdForDisplay(int id) {
        Game game = gameDao.getGameById(id);
        ArrayList<Character> placeholder = new ArrayList<>();
        
        if (!game.isComplete()) {
            game.setSolution(placeholder);
        }

        return game;
    }

    public List<Round> getRoundsByGameId(int id) {
        return roundDao.getRoundsByGameId(id);
    }

    public void clearStorage() {
        gameDao.clearStorage();
        roundDao.clearStorage();
    }

    private class SortById implements Comparator<Game> {

        @Override
        public int compare(Game a, Game b) {
            return a.getId() - b.getId();
        }
    }
}
