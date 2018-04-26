package com.robert.calculator.controller;

import com.robert.calculator.model.Countries;
import com.robert.calculator.model.Rates;
import com.robert.calculator.service.NBPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class HelloController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getCalculatorPage()
    {
        return "Calculator";
    }


}
