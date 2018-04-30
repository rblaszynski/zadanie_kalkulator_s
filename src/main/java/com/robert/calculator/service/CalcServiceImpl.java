package com.robert.calculator.service;

//import com.robert.calculator.model.CountryRepository;

import com.robert.calculator.model.CountryList;
import com.robert.calculator.model.ExchangeRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@org.springframework.stereotype.Service
public class CalcServiceImpl implements CalcService {

    @Override
    public BigDecimal getExchangeRate(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "?format=json";
        ResponseEntity<ExchangeRate> entity = restTemplate.getForEntity(url, ExchangeRate.class);
        return entity.getBody().getRates().get(0).getMid();
    }

    @Override
    public BigDecimal calcSalary(String code, BigDecimal dailyIncome) {
        BigDecimal tax = new BigDecimal(1).subtract(Objects.requireNonNull(CountryList.getTaxByCode(code)));
        BigDecimal fixed = CountryList.getFixedCostByCode(code);
        BigDecimal calculated;
        if (code.equals("PLN")) {
            calculated = (dailyIncome.multiply(new BigDecimal(22).multiply(tax)).subtract(Objects.requireNonNull(fixed))).setScale(2, RoundingMode.HALF_EVEN);
            return calculated;
        } else {
            calculated = (dailyIncome.multiply(new BigDecimal(22).multiply(tax)).subtract(Objects.requireNonNull(fixed))).multiply(getExchangeRate(code)).setScale(2, RoundingMode.HALF_EVEN);
            return calculated;
        }
    }
}
