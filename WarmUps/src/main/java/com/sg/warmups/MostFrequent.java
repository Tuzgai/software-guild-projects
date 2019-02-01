package com.sg.warmups;

import java.util.HashMap;


/**
 *
 * @author Stuart
 */
public class MostFrequent {
    public static void main(String[] args) {
        
    }
    
    public int findMostFrequent (int [] arr) {
        HashMap<Integer,Integer> table = new HashMap<>();
        
        for(int item : arr) {
            if (table.get(item) == null) {
                table.put(item, 1);
            } else {
                table.put(item, table.get(item)+1);
            }
        }
        
        int highestKey = 0, highestValue = 0;
        for(Integer key : table.keySet()){
            if(table.get(key) > highestValue) {
                highestKey = key;
                highestValue = table.get(key);
            }
        }
        
        return highestKey;
    }
}
