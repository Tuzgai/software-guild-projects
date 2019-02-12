package com.sg.flooringmastery.dao.taxesdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class TaxesDaoFileImpl implements TaxesDao {

    private static final String DELIMITER = ",";
    private String path;
    private static final String TAX_FILE = "Taxes.txt";

    public TaxesDaoFileImpl(String path) {
        this.path = path;
    }

    @Override
    public HashMap<String, BigDecimal> loadTaxes() throws FlooringMasteryDaoFileException {
        HashMap<String, BigDecimal> map = new HashMap<>();
        Scanner scn;

        try {
            scn = new Scanner(new File(path + TAX_FILE));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("File not found: " + TAX_FILE);
        }
        
        // skip the header line
        scn.nextLine();
        
        String currentLine;
        String[] currentTokens;
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lines
            if (currentTokens.length == 2) {
                map.put(currentTokens[0], new BigDecimal(currentTokens[1]));
            }
        }

        scn.close();
        return map;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
