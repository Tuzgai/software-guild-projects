/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.deckofcards;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author kylerudy
 */
public class Deck {
    List<Card> deck;
    
    public Deck() {
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card drawCard() {
        return deck.remove(0);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
    
}
