package com.sg.warmups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Stuart
 */
public class CoinsAndDice {

    public static int coinToss() {
        Random rng = new Random();

        return rng.nextInt(2);
    }

    public static int tenTosses() {
        return coinToss() + coinToss() + coinToss() + coinToss() + coinToss() + coinToss() + coinToss() + coinToss() + coinToss() + coinToss();
    }

    public static int rollD6() {
        while (true) {
            int top = -1;
            int topIndex = -1;
            int side;
            ArrayList<Integer> sides = new ArrayList();

            // Generate a number 1-10 for each side, then return highest side
            for (int i = 0; i < 6; i++) {
                sides.add(i, tenTosses());
            }

            for (int i = 0; i < 6; i++) {
                if (sides.get(i) > top) {
                    top = sides.get(i);
                    topIndex = i;
                // If there's a tie for top roll, flip between the options
                } else if (sides.get(i) == top) {
                    if (coinToss() == 0) {
                        top = -1;
                        topIndex = -1;
                        break;
                    } else {
                        top = sides.get(i);
                        topIndex = i;
                    }
                }
            }

            if (topIndex > -1) {
                return topIndex + 1;
            }
        }
    }

    public static void main(String[] args) {
        int n;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10000000; i++) {
            n = rollD6();

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        map.forEach((k, v) -> System.out.println("K:" + k + " V:" + v));
    }
}
