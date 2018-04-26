package com.robert.calculator.controller;

import com.robert.calculator.service.NBPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloRestController {

    @Autowired
    private NBPservice nbpservice;

    @RequestMapping(value="/{code}/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> getRate(@PathVariable("code")String code, @PathVariable("salary")BigDecimal salary){
        BigDecimal calculated = nbpservice.getExchangeRate(code).multiply(new BigDecimal(22)).multiply(salary);
        System.out.println("SALARY: "+calculated);
        return new ResponseEntity<BigDecimal>(calculated, HttpStatus.OK);
    }
}
