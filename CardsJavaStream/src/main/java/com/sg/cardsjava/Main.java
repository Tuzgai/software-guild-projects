package com.sg.cardsjava;

import com.sg.cardsjava.Card.Rank;
import com.sg.cardsjava.Card.Suit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kdrudy on 9/12/16.
 */
public class Main {

    public static boolean isFlush(Set<Card> hand) {
        Set<Suit> suits = hand.stream()
                .map((c) -> c.getSuit())
                .collect(Collectors.toSet());

        return suits.size() == 1;
    }

    public static boolean isStraight(HashSet<Card> hand) {
        List<Card.Rank> cards = hand.stream()
                .map((c) -> c.getRank())
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getVal() != cards.get(i + 1).getVal() - 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStraightFlush(HashSet<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    public static boolean isFourOfAKind(HashSet<Card> hand) {
        Set<Card.Rank> ranks = hand.stream()
                .map((c) -> c.getRank())
                .collect(Collectors.toSet());

        return ranks.size() == 1;
    }

    public static boolean isThreeOfAKind(HashSet<Card> hand) {
        Map<Integer, List<Rank>> map = hand.stream()
                .map((c) -> c.getRank()) // Stream of ranks
                .collect(Collectors.groupingBy((c) -> c.getVal()));     // Map<Rank, List<Rank>>

        for (Map.Entry<Integer, List<Rank>> entry : map .entrySet()) {
            if (entry.getValue().size() == 3) {
                return true;
            }
            
            // According to the tests, 4 of a kind is 2 pair
            if (entry.getValue().size() == 4) return true;
        }

        return false;
    }
   
    public static boolean isTwoPair(HashSet<Card> hand) {
        Map<Integer, List<Rank>> map = hand.stream()
                .map((c) -> c.getRank()) // Stream of ranks
                .collect(Collectors.groupingBy((c) -> c.getVal()));     // Map<Rank, List<Rank>>
        int count = 0;
        for (Map.Entry<Integer, List<Rank>> entry : map.entrySet()) {
            if (entry.getValue().size() == 2) {
                count++;
            }
            
            // According to the tests, 4 of a kind is 2 pair
            if (entry.getValue().size() == 4) return true;
        }

        return count == 2;
    }

    private static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    private static HashSet<HashSet<Card>> createHands(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        deck.forEach((c1) -> {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            deck2.forEach((c2) -> {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                deck3.forEach((c3) -> {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    deck4.stream().map((c4) -> {
                        HashSet<Card> hand = new HashSet();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        return hand;
                    }).forEachOrdered((hand) -> {
                        hands.add(hand);
                    });
                });
            });
        });
        return hands;
    }

    public static void main(String args[]) {

        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> allHands = createHands(deck);
        System.out.println("Total Hands: " + allHands.size());
        HashSet<HashSet<Card>> straightHands = allHands;
        straightHands = straightHands.stream()
                .filter(Main::isStraight)
                .filter((h) -> !isStraightFlush(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Straights (2520)" + straightHands.size());

        HashSet<HashSet<Card>> flushHands = allHands;
        flushHands = flushHands.stream()
                .filter(Main::isFlush)
                .filter((h) -> !isStraightFlush(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Flushes (2820)" + flushHands.size());

        HashSet<HashSet<Card>> straightFlushHands = allHands;
        straightFlushHands = straightFlushHands.stream()
                .filter(Main::isStraightFlush)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Straight Flushes (40)" + straightFlushHands.size());

        HashSet<HashSet<Card>> fourKindHands = allHands;
        fourKindHands = fourKindHands.stream()
                .filter(Main::isFourOfAKind)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Four of a kinds (13)" + fourKindHands.size());

        HashSet<HashSet<Card>> threeKindHands = allHands;
        threeKindHands = threeKindHands.stream()
                .filter(Main::isThreeOfAKind)
                .filter((h) -> !isFourOfAKind(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Three of a kinds (2496)" + threeKindHands.size());

        HashSet<HashSet<Card>> twoPairHands = allHands;
        twoPairHands = twoPairHands.stream()
                .filter(Main::isTwoPair)
                .filter((h) -> !isFourOfAKind(h))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Two pairs (2808)" + twoPairHands.size());
    }
}
