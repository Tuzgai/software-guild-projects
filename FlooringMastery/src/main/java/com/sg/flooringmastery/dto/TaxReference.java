package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stuart
 */
public class TaxReference {
    Map<String, BigDecimal> map;

    public TaxReference() {
        map = new HashMap<>();
    }
    
    public BigDecimal getTaxByState(String state) {
        if(map.containsKey(state)) {
            return map.get(state);
        }
        
        // This might need to be an exception later
        return null;
    }
    
    public void addState(String state, BigDecimal tax) {
        map.put(state, tax);
    }   
}
