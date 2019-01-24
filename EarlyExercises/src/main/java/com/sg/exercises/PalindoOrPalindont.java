package com.sg.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class PalindoOrPalindont {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String word;

        System.out.print("Gimme a palindrome: ");
        word = scn.nextLine();

        if (isPalindrome(word)) {
            System.out.println("That's a nice palindrome you've got there!");
        } else {
            System.out.println("Hey, that's no palindrome, get outta here.");
        }
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        
        // It's probably better to just do this all with chars but I want to
        // try generic methods and they don't accept primitives
        Character[] characterArray = new Character[charArray.length];
        Character[] reversed = new Character[charArray.length];
        int counter = 0;

        for (int i = charArray.length - 1; i >= 0; i--) {
            characterArray[i] = (Character) charArray[i];
            reversed[counter] = characterArray[i];
            counter++;
        }
        
        return arrayEquals(characterArray, reversed);
    }

    public static <T> boolean arrayEquals(T[] a1, T[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (!a1[i].equals(a2[i])) {
                return false;
            }
        }
        return true;
    }
}
