package com.sg.warmups;

/**
 *
 * @author Stuart
 */
public class RotateArray {

    public int[] rotateArray(int[] arr, int rot) {
        int[] out = new int[arr.length];
        int length = arr.length;
        if (rot > length) {
            rot = rot % length;
        }
        int start = length - rot;
        int count = 0;

        // Loop from start point to end, filling front of output
        for (int i = start; i < length; i++) {
            out[count] = arr[i];
            count++;
        }

        // Loop to fill the rest of the output
        int count2 = 0;
        for (int i = count; i < length; i++) {
            out[i] = arr[count2];
            count2++;
        }

        return out;
    }
}
