package com.sg.wordgame.dao;

import java.io.FileNotFoundException;

/**
 *
 * @author Stuart
 */
public interface WordGameDao{
    public String getWord() throws FileNotFoundException;
}
