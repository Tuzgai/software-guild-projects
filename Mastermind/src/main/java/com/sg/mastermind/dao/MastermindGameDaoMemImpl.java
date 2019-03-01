package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Game;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */

@Repository
@Profile("memory")
public class MastermindGameDaoMemImpl implements MastermindGameDao {
    ArrayList<Game> games;

    public MastermindGameDaoMemImpl() {
        games = new ArrayList<>();
    }
    
    @Override
    public Game createGame (Game game) {
        int newId = games.stream()
                .mapToInt(g -> g.getId())
                .max().orElse(0) + 1;
        
        game.setId(newId);
        games.add(game);
        return game;
    }
    
    @Override
    public Game getGameById(int id) {
        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst().orElse(null);
    }
    
    @Override
    public List<Game> getAllGames() {
        ArrayList<Game> a = new ArrayList<>();
        a.add(new Game());
        return a;
    }
   
    // Needed for testing
    @Override
    public void clearStorage() {
        games.clear();
    }
}