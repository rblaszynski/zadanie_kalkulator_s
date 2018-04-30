package com.robert.calculator.controller;

import com.robert.calculator.model.CountryList;
import com.robert.calculator.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AppRestController {

    private final CalcService calcService;
    CountryList countryList = new CountryList();

    @Autowired
    public AppRestController(CalcService calcService) {
        this.calcService = calcService;
    }


    @RequestMapping(value = "/calculate/{code}/{salary:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> getRate(@PathVariable("code") String code, @PathVariable("salary") BigDecimal salary) {
        BigDecimal calculated = calcService.calcSalary(code, salary);
        System.out.println("SALARY: " + calculated);

        return new ResponseEntity<>(calculated, HttpStatus.OK);
    }

    @RequestMapping(value = "/countries/codes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllCodes() {
        return new ResponseEntity<>(CountryList.getCountryCodes(), HttpStatus.OK);
    }

}
