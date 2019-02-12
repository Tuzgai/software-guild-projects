package com.sg.flooringmastery.dao.productsdao;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.dto.ProductType;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class ProductsDaoFileImpl implements ProductsDao {

    private static final String DELIMITER = ",";
    private String path;
    private static final String PRODUCT_FILE = "Products.txt";

    public ProductsDaoFileImpl(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<ProductType> loadProducts() throws FlooringMasteryDaoFileException {
        ArrayList<ProductType> list = new ArrayList<>();
        Scanner scn;
        ProductType product;

        try {
            scn = new Scanner(new File(path + PRODUCT_FILE));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDaoFileException("File not found: " + PRODUCT_FILE);
        }

        String currentLine;
        String[] currentTokens;
        
        // skip the header line
        scn.nextLine();
        
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lines
            if (currentTokens.length == 3) {
                product = new ProductType(
                        currentTokens[0],
                        new BigDecimal(currentTokens[1]),
                        new BigDecimal(currentTokens[2]));
                list.add(product);
            }

        }

        return list;
    }
    
    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
