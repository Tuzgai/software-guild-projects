package com.sg.flooringmastery.dao.taxesdao;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Stuart
 */
public class TaxesDaoStub implements TaxesDao {

    // Return one state
    @Override
    public HashMap<String, BigDecimal> loadTaxes() {
        HashMap<String, BigDecimal> map = new HashMap<>();
        map.put("MN", new BigDecimal("5.00"));
        return map;
    }

    @Override
    public void setPath(String path) {
        // Do nothing
    }

}
