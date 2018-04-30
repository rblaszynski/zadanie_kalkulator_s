package com.robert.calculator.service;

import java.math.BigDecimal;

public interface CalcService {
    BigDecimal getExchangeRate(String name);
    BigDecimal calcSalary(String code, BigDecimal dailyIncome);
}
