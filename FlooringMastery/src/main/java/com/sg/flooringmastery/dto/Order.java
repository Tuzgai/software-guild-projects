package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author Stuart
 */
public class Order {

    final private int orderNumber;
    private LocalDate date;
    private String custName;
    private String state;
    private BigDecimal taxRate;
    private ProductType productType;
    private BigDecimal areaSquareFeet;

    public Order(int orderNumber, LocalDate date, String custName, String state, BigDecimal taxRate, ProductType productType, BigDecimal areaSquareFeet) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.custName = custName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.areaSquareFeet = areaSquareFeet;
    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return productType.getMaterialCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return productType.getLaborCostPerSquareFoot();
    }

    public BigDecimal getMaterialCost() {
        BigDecimal output = areaSquareFeet.multiply(productType.getMaterialCostPerSquareFoot());
        return output.setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getLaborCost() {
        BigDecimal output =  areaSquareFeet.multiply(productType.getLaborCostPerSquareFoot());
        return output.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTaxCharged() {
        BigDecimal output = getMaterialCost().add(getLaborCost()).multiply(taxRate);
        return output.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        BigDecimal output = getMaterialCost().add(getLaborCost()).add(getTaxCharged());
        return output.setScale(2, RoundingMode.HALF_UP);
    }

    public int getOrderNumber() {
        return orderNumber;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
