package com.sg.wordgame.dao;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 *
 * @author Stuart
 */
public class WordGameDaoFileImpl implements WordGameDao {

    public static final String WORDS_FILE = "words.txt";

    @Override
    public String getWord() throws FileNotFoundException {
        Scanner scn;
        Random rng = new Random();
        String word = "";
        
        try {
            scn = new Scanner(new File(WORDS_FILE));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Could not load words file");
        }
        
        int choice = rng.nextInt(10000);
        
        for(int i = 0; i < choice; i++) {
            word = scn.nextLine();
        }
        
        return word;
    }

}
