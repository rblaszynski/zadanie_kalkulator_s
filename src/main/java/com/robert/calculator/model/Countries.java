package com.robert.calculator.model;

import java.math.BigDecimal;

public class Countries {
    private final String countryName;
    private final String code;
    private final BigDecimal tax;
    private final BigDecimal fixedCost;

    public Countries(String countryName, String code, BigDecimal tax, BigDecimal fixedCost) {
        this.countryName = countryName;
        this.code = code;
        this.tax = tax;
        this.fixedCost = fixedCost;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getFixedCost() {
        return fixedCost;
    }
}
