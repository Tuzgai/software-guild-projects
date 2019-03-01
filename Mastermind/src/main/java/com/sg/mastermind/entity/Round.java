package com.sg.mastermind.entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Stuart
 */
public class Round {
    int id;
    char[] guess;
    int exactMatches;
    int partialMatches;
    LocalDateTime timestamp;
    int gameId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getGuess() {
        return guess;
    }

    public void setGuess(char[] guess) {
        this.guess = guess;
    }

    public int getExactMatches() {
        return exactMatches;
    }

    public void setExactMatches(int exactMatches) {
        this.exactMatches = exactMatches;
    }

    public int getPartialMatches() {
        return partialMatches;
    }

    public void setPartialMatches(int partialMatches) {
        this.partialMatches = partialMatches;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Arrays.hashCode(this.guess);
        hash = 83 * hash + this.exactMatches;
        hash = 83 * hash + this.partialMatches;
        hash = 83 * hash + Objects.hashCode(this.timestamp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.exactMatches != other.exactMatches) {
            return false;
        }
        if (this.partialMatches != other.partialMatches) {
            return false;
        }
        if (!Arrays.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        return true;
    }
    
    
}