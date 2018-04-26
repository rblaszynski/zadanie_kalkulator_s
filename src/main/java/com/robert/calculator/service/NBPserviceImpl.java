package com.robert.calculator.service;

import com.robert.calculator.model.ExchangeRate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class NBPserviceImpl implements NBPservice {
    @Override
    public BigDecimal getExchangeRate(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/"+name+"?format=json";
        ResponseEntity<ExchangeRate> entity = restTemplate.getForEntity(url, ExchangeRate.class);
        System.out.println("API: "+entity.getBody().getRates().get(0).getMid());
        return entity.getBody().getRates().get(0).getMid();
    }
}
