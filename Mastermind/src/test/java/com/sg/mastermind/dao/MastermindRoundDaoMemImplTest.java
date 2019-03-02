package com.sg.mastermind.dao;

import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Stuart
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MastermindRoundDaoMemImplTest {

    @Autowired
    MastermindGameDao gameDao;

    @Autowired
    MastermindRoundDao roundDao;

    public MastermindRoundDaoMemImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        gameDao.clearStorage();
        roundDao.clearStorage();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRoundsByGame method, of class MastermindRoundDaoMemImpl.
     */
    @Test
    public void testCreateGetRoundsByGame() {
        Game game = new Game();
        game.setComplete(true);
        ArrayList<Character> solution = new ArrayList<>(Arrays.asList('1', '2', '3', '4'));
        game.setSolution(solution);
        gameDao.createGame(game);

        Game game2 = new Game();
        game2.setComplete(true);
        ArrayList<Character> solution2 = new ArrayList<>(Arrays.asList('1', '2', '3', '4'));

        game2.setSolution(solution2);
        gameDao.createGame(game2);

        Round round = new Round();
        // Normally id will be provided by DAO, but this will make equality
        // testing easier
        round.setId(1);
        round.setExactMatches(4);
        round.setPartialMatches(0);
        round.setGameId(1);
        ArrayList<Character> guess = new ArrayList<>(Arrays.asList('1', '2', '3', '4'));
        round.setGuess(guess);
        round.setTimestamp(LocalDateTime.MAX);

        roundDao.createRound(round);

        Round round2 = new Round();
        round2.setId(2);
        round2.setExactMatches(2);
        round2.setPartialMatches(0);
        round2.setGameId(1);
        ArrayList<Character> guess2 = new ArrayList<>(Arrays.asList('4', '3', '2', '1'));
        round2.setGuess(guess2);
        round2.setTimestamp(LocalDateTime.MAX);

        roundDao.createRound(round2);

        Round round3 = new Round();
        round3.setId(3);
        round3.setExactMatches(0);
        round3.setPartialMatches(2);
        round3.setGameId(2);
        ArrayList<Character> guess3 = new ArrayList<>(Arrays.asList('5', '6', '7', '8'));
        round3.setGuess(guess3);
        round3.setTimestamp(LocalDateTime.MAX);

        roundDao.createRound(round3);

        List<Round> roundList = roundDao.getRoundsByGameId(1);

        assertEquals(2, roundList.size());
        assertTrue(roundList.contains(round));
        assertTrue(roundList.contains(round2));
    }

    /**
     * Test of clearStorage method, of class MastermindRoundDaoMemImpl.
     */
    @Test
    public void testClearStorage() {
        Round round = new Round();
        round.setExactMatches(4);
        round.setPartialMatches(0);
        round.setGameId(1);
        ArrayList<Character> guess = new ArrayList<>(Arrays.asList('1','2','3','4'));
        round.setGuess(guess);
        round.setTimestamp(LocalDateTime.MAX);

        roundDao.createRound(round);

        roundDao.clearStorage();
        assertEquals(0, roundDao.getRoundsByGameId(1).size());
    }

}
