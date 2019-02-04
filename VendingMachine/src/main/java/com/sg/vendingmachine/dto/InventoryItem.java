package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author Stuart
 */
public class InventoryItem {
    private String name;
    private BigDecimal price;
    private int stockLevel;
    private final MathContext mc;
    
    public InventoryItem(String name) {
        this.mc = new MathContext(2, RoundingMode.HALF_UP);
        this.name = name;
        this.price = new BigDecimal("0", mc);
        this.stockLevel = 0;
    }
    
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        return true;
    }
    
    
}
