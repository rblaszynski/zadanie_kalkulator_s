package com.robert.calculator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class CountryList {
    private static final List<Country> countries = new ArrayList<>();

    public CountryList() {
        countries.add(new Country("Polska", "PLN", new BigDecimal(0.19), new BigDecimal(1200)));
        countries.add(new Country("Niemcy", "EUR", new BigDecimal(0.20), new BigDecimal(800)));
        countries.add(new Country("Wielka Brytania", "GBP", new BigDecimal(0.25), new BigDecimal(600)));
    }

    public static String getCountryCodes() {
        StringBuilder code = new StringBuilder("[");
        for (int i = 0; i < countries.size(); i++) {
            if (i != countries.size() - 1) {
                String temp = "{\"name\":\"" + countries.get(i).getCountryName() + "\" ,\"code\":\"" + countries.get(i).getCode() + "\"},";
                code.append(temp);
            } else {
                String temp = "{\"name\":\"" + countries.get(i).getCountryName() + "\" ,\"code\":\"" + countries.get(i).getCode() + "\"}";
                code.append(temp);
            }
        }
        code.append("]");
        return code.toString();
    }

    public static BigDecimal getTaxByCode(String code) {
        for (Country c : countries) {
            if (c.getCode().equals(code)) return c.getTax();
        }
        return null;
    }

    public static BigDecimal getFixedCostByCode(String code) {
        for (Country c : countries) {
            if (c.getCode().equals(code)) return c.getFixedCost();
        }
        return null;
    }
}
