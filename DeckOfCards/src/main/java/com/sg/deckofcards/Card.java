/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.deckofcards;

/**
 *
 * @author kylerudy
 */
public class Card {
    private Rank rank;
    private Suit suit;
    
    private boolean used = false;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRankString() {
        String retVal = "";
        switch(rank) {
            case ACE:
                retVal = "Ace";
                break;
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
            case TEN:
                retVal = Integer.toString(rank.getValue());
                break;
            case JACK:
                retVal = "Jack";
                break;
            case QUEEN:
                retVal = "Queen";
                break;
            case KING:
                retVal = "King";
                break;
                
        }
        return retVal;
    }
    
    public String getSuitString() {
        String retVal = "";
        switch(suit){
            case HEARTS:
                retVal = "Hearts";
                break;
            case DIAMONDS:
                retVal = "Diamonds";
                break;
            case SPADES:
                retVal = "Spades";
                break;
            case CLUBS:
                retVal = "Clubs";
                break;
        }
        
        return retVal;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    
    
}
