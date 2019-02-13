package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Stuart
 */
public class Order {

    private LocalDate date;
    private int orderNumber;
    private String custName;
    private String state;
    private BigDecimal taxRate;
    private ProductType productType;
    private BigDecimal areaSquareFeet;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxPaid;
    private BigDecimal total;

    public void updateDerivedFields() {
        materialCost = areaSquareFeet.multiply(productType.getMaterialCostPerSquareFoot());
        materialCost = materialCost.setScale(2, RoundingMode.HALF_UP);

        laborCost = areaSquareFeet.multiply(productType.getLaborCostPerSquareFoot());
        laborCost = laborCost.setScale(2, RoundingMode.HALF_UP);
        
        // Tax rate is stored and displayed as %, but needs to be decimal for math
        BigDecimal decimalTaxRate = taxRate.divide(new BigDecimal("100.00"));
        taxPaid = materialCost.add(laborCost).multiply(decimalTaxRate);
        taxPaid = taxPaid.setScale(2, RoundingMode.HALF_UP);

        total = materialCost.add(laborCost).add(taxPaid);
        total = total.setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return productType.getMaterialCostPerSquareFoot();
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return productType.getLaborCostPerSquareFoot();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getAreaSquareFeet() {
        return areaSquareFeet;
    }

    public void setAreaSquareFeet(BigDecimal areaSquareFeet) {
        this.areaSquareFeet = areaSquareFeet;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(BigDecimal taxPaid) {
        this.taxPaid = taxPaid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.date);
        hash = 23 * hash + this.orderNumber;
        hash = 23 * hash + Objects.hashCode(this.custName);
        hash = 23 * hash + Objects.hashCode(this.state);
        hash = 23 * hash + Objects.hashCode(this.taxRate);
        hash = 23 * hash + Objects.hashCode(this.productType);
        hash = 23 * hash + Objects.hashCode(this.areaSquareFeet);
        hash = 23 * hash + Objects.hashCode(this.materialCost);
        hash = 23 * hash + Objects.hashCode(this.laborCost);
        hash = 23 * hash + Objects.hashCode(this.taxPaid);
        hash = 23 * hash + Objects.hashCode(this.total);
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
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.custName, other.custName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.areaSquareFeet, other.areaSquareFeet)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.taxPaid, other.taxPaid)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

}
