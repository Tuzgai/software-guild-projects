package com.sg.flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author Stuart
 */
public class ProductType {
    final private String name;
    final private BigDecimal materialCostPerSquareFoot;
    final private BigDecimal laborCostPerSquareFoot;

    public ProductType(String name, BigDecimal materialCostPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
        this.name = name;
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }
    
    
}
