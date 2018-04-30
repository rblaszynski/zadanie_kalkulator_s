package com.robert.calculator.service;

import com.robert.calculator.model.CountryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalcServiceImplTest {
    private CalcService calcService;
    private RestTemplate restTemplate;
    private BigDecimal rate;


    @BeforeEach
    void initExchangeRate()
    {
        calcService = new CalcServiceImpl();

    }

    //Exchange rates for EUR and GBP on 30.04.2018 are 4.2204 and 4.7888
    @Test
    void getExchangeRate() {
        assertEquals(4.2204, calcService.getExchangeRate("EUR").doubleValue(), 0.01);
        assertEquals(4.7888, calcService.getExchangeRate("GBP").doubleValue(), 0.01);
    }

    @Test
    void calcSalary() {
        CountryList countryList = new CountryList();
        assertEquals(2364, calcService.calcSalary("PLN", new BigDecimal(200)).doubleValue(), 0.01);
        assertEquals(4051.58, calcService.calcSalary("EUR", new BigDecimal(100)).doubleValue(), 0.01);
        assertEquals(-1200, calcService.calcSalary("PLN", new BigDecimal(0)).doubleValue(), 0.01);
    }
}