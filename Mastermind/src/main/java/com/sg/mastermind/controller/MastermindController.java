package com.sg.mastermind.controller;

import com.sg.mastermind.dao.service.MastermindService;
import com.sg.mastermind.entity.Game;
import com.sg.mastermind.entity.Round;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Stuart
 */
@RestController
@RequestMapping("/api/mastermind")
public class MastermindController {
    @Autowired
    MastermindService service;
    
    @PostMapping("/begin")
    public ResponseEntity<Integer> startGame() {
        return ResponseEntity.ok(service.startNewGame().getId());
    }
    
    @PostMapping("/guess/{gameId}")
    public ResponseEntity<Round> makeGuess(@PathVariable int gameId, @RequestBody ArrayList<Character> guess) {
        return ResponseEntity.ok(service.makeGuess(guess, gameId));
    }
    
    @GetMapping("/game")
    public ResponseEntity<List<Game>> displayGames() {
        return ResponseEntity.ok(service.getAllGamesForDisplay());
    }
    
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> displayOneGame(@PathVariable int gameId) {
        return ResponseEntity.ok(service.getGameByIdForDisplay(gameId));
    }
    
    @GetMapping("/rounds/{gameId}")
    public ResponseEntity<List<Round>> displayRounds(@PathVariable int gameId) {
        return ResponseEntity.ok(service.getRoundsByGameId(gameId));
    }
    
    @GetMapping("/testList")
    public ResponseEntity<ArrayList<Character>> displaySampleList() {
        ArrayList<Character> list = new ArrayList(Arrays.asList('1','2','3','4'));
        return ResponseEntity.ok(list);
    }
}
