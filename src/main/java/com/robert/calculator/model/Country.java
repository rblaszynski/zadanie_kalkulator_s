package com.robert.calculator.model;

import java.math.BigDecimal;

class Country {
    private String countryName;
    private String code;
    private BigDecimal tax;
    private BigDecimal fixedCost;

    Country(String countryName, String code, BigDecimal tax, BigDecimal fixedCost) {
        this.countryName = countryName;
        this.code = code;
        this.tax = tax;
        this.fixedCost = fixedCost;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(BigDecimal fixedCost) {
        this.fixedCost = fixedCost;
    }


}
