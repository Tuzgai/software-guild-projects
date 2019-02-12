package com.sg.flooringmastery.dao.taxesdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Stuart
 */
public interface TaxesDao {

    public HashMap<String, BigDecimal> loadTaxes() throws FlooringMasteryDaoFileException;

    void setPath(String path);
}
