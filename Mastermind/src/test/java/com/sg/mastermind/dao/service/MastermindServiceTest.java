package com.sg.mastermind.dao.service;

import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.util.HashSet;
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
public class MastermindServiceTest {

    @Autowired
    MastermindService instance;

    public MastermindServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance.clearStorage();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of startNewGame method, of class MastermindService.
     */
    @Test
    public void testStartNewGame() {
        Game game = instance.startNewGame();

        HashSet<Character> hs = new HashSet<>();
        for (char i : game.getSolution()) {
            hs.add(i);
        }

        // Is the solution 4 unique characters?
        assertEquals(4, hs.size());

        instance.startNewGame();
        instance.startNewGame();

        // Did all three games get added?
        assertEquals(3, instance.getAllGamesForDisplay().size());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessAllMatch() {
        Game game = instance.startNewGame();
        char[] guess = game.getSolution();

        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(4, r.getExactMatches());
        assertEquals(0, r.getPartialMatches());
        assertTrue(instance.getGameByIdForDisplay(game.getId()).isComplete());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessNoneMatch() {
        Game game = instance.startNewGame();
        char[] guess = {'A','B','C','D'};

        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(0, r.getExactMatches());
        assertEquals(0, r.getPartialMatches());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessSomeExactMatch() {
        Game game = instance.startNewGame();
        char[] guess = game.getSolution();
        guess[0] = 'Z';
        guess[1] = 'A';
        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(2, r.getExactMatches());
        assertEquals(0, r.getPartialMatches());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessAllPartialMatch() {
        Game game = instance.startNewGame();
        char[] guess = game.getSolution();

        // Just reverse the array
        // Note: this will break if we ever use non-unique guess choices
        for (int i = 0; i < guess.length / 2; i++) {
            char temp = guess[i];
            guess[i] = guess[guess.length - i - 1];
            guess[guess.length - i - 1] = temp;
        }

        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(0, r.getExactMatches());
        assertEquals(4, r.getPartialMatches());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessSomePartialMatch() {
        Game game = instance.startNewGame();
        char[] guess = game.getSolution();

        // Just reverse the array
        // Note: this will break if we ever use non-unique guess choices
        for (int i = 0; i < guess.length / 2; i++) {
            char temp = guess[i];
            guess[i] = guess[guess.length - i - 1];
            guess[guess.length - i - 1] = temp;
        }

        guess[3] = 'Z';
        guess[2] = 'A';
        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(0, r.getExactMatches());
        assertEquals(2, r.getPartialMatches());
    }

    /**
     * Test of makeGuess method, of class MastermindService.
     */
    @Test
    public void testMakeGuessSomePartialSomeExactMatch() {
        Game game = instance.startNewGame();
        char[] guess = game.getSolution();

        char temp = guess[0];
        guess[0] = guess[guess.length-1];
        guess[guess.length-1] = temp;

        Round r = instance.makeGuess(guess, game.getId());

        assertEquals(2, r.getExactMatches());
        assertEquals(2, r.getPartialMatches());
    }

    /**
     * Test of getAllGamesForDisplay method, of class MastermindService.
     */
    @Test
    public void testGetAllGamesForDisplay() {
        Game game1 = instance.startNewGame();
        Game game2 = instance.startNewGame();
        Game game3 = instance.startNewGame();
        
        char[] guess = game2.getSolution();

        instance.makeGuess(guess, game2.getId());
        
        List<Game> gameList = instance.getAllGamesForDisplay();
        
        // Game 1 should be blank
        Game testGame = instance.getGameByIdForDisplay(game1.getId());
        HashSet<Character> hs = new HashSet<>();
        
        for(char c : testGame.getSolution()) {
            hs.add(c);
        }
        
        assertEquals(1, hs.size());
        
        // Game 2 should be populated
        testGame = instance.getGameByIdForDisplay(game2.getId());
        hs = new HashSet<>();
        
        for(char c : testGame.getSolution()) {
            hs.add(c);
        }
        
        assertEquals(4, hs.size());
        
        // Game 3 should be blank
        testGame = instance.getGameByIdForDisplay(game3.getId());
        hs = new HashSet<>();
        
        for(char c : testGame.getSolution()) {
            hs.add(c);
        }
        
        assertEquals(1, hs.size());
    }

    /**
     * Test of getGameByIdForDisplay method, of class MastermindService.
     */
    @Test
    public void testGetGameByIdForDisplayGuessCorrect() {
        Game game1 = instance.startNewGame();
        Game game2 = instance.startNewGame();
        Game game3 = instance.startNewGame();
        
        char[] guess = game2.getSolution();

        instance.makeGuess(guess, game2.getId());
        
        Game testGame = instance.getGameByIdForDisplay(game2.getId());
        HashSet<Character> hs = new HashSet<>();
        
        // Check if we got the solution
        for(char c : testGame.getSolution()) {
            hs.add(c);
        }
        
        assertEquals(4, hs.size());
        
        // Check an unsolved one for placeholder array
        testGame = instance.getGameByIdForDisplay(game3.getId());
        hs = new HashSet<>();
        
        // Check if we got the solution
        for(char c : testGame.getSolution()) {
            hs.add(c);
        }
        
        assertEquals(1, hs.size());
    }

    /**
     * Test of getRoundsByGameId method, of class MastermindService.
     */
    @Test
    public void testGetRoundsByGameId() {
        // Passthrough from dao, no test needed
    }

}
