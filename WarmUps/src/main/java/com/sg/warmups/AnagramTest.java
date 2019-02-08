package com.sg.warmups;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stuart
 */
public class AnagramTest {

    public boolean anagramTest(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (char item : arrA) {
            if (mapA.get(item) == null) {
                mapA.put(item, 1);
            } else {
                mapA.put(item, mapA.get(item) + 1);
            }
        }

        for (char item : arrB) {
            if (mapB.get(item) == null) {
                mapB.put(item, 1);
            } else {
                mapB.put(item, mapB.get(item) + 1);
            }
        }

        return mapA.equals(mapB);
    }
}
