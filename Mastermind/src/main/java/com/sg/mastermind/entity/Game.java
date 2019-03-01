package com.sg.mastermind.entity;

import java.util.Arrays;

/**
 *
 * @author Stuart
 */
public class Game {
    int id;
    char[] solution;
    boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getSolution() {
        return solution;
    }

    public void setSolution(char[] solution) {
        this.solution = solution;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Arrays.hashCode(this.solution);
        hash = 11 * hash + (this.complete ? 1 : 0);
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
        final Game other = (Game) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.complete != other.complete) {
            return false;
        }
        if (!Arrays.equals(this.solution, other.solution)) {
            return false;
        }
        return true;
    }
}