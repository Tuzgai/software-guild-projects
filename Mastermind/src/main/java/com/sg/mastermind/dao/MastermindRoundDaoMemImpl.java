package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */
@Repository
@Profile("memory")
public class MastermindRoundDaoMemImpl implements MastermindRoundDao {
    ArrayList<Round> rounds;

    public MastermindRoundDaoMemImpl() {
        rounds = new ArrayList<>();
    }
    
    @Override
    public Round createRound(Round round) {
        int newId = rounds.stream()
                .mapToInt(g -> g.getId())
                .max().orElse(0) + 1;

        round.setId(newId);
        rounds.add(round);
        return round;
    }
    
    @Override
    public List<Round> getRoundsByGame(Game game) {
        return rounds.stream()
                .filter(r -> r.getGameId() == game.getId())
                .collect(Collectors.toList());
    }
    
    @Override
    // Needed for testing
    public void clearStorage() {
        rounds.clear();
    }
}
