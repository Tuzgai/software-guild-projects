package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Round;
import java.time.LocalDateTime;
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
        round.setTimestamp(LocalDateTime.now());
        rounds.add(round);
        return round;
    }
    
    @Override
    public List<Round> getRoundsByGameId(int id) {
        return rounds.stream()
                .filter(r -> r.getGameId() == id)
                .collect(Collectors.toList());
    }
    
    @Override
    // Needed for testing
    public void clearStorage() {
        rounds.clear();
    }
}
