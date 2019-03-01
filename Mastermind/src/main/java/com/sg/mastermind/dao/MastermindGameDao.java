package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Game;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface MastermindGameDao {
    public Game createGame (Game game);
    public Game getGameById(int id);
    public List<Game> getAllGames();
    public void clearStorage();
}
