package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface MastermindRoundDao {
    public Round createRound(Round round);
    public List<Round> getRoundsByGame(Game game);
    public void clearStorage();
}
