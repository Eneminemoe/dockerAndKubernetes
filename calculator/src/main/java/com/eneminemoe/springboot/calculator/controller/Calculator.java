package com.eneminemoe.springboot.calculator.controller;

import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class Calculator {

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    private int rand=0;
    @GetMapping("/add")
    public String add(@RequestParam(value = "add1", defaultValue = "0") String addOne,@RequestParam(value = "add2", defaultValue = "0") String addTwo){
        return String.valueOf(Integer.getInteger(addOne) + Integer.getInteger(addTwo));
    }

    @GetMapping("/sub")
    public String substract(@RequestParam(value = "sub1", defaultValue = "0") String subOne,@RequestParam(value = "sub2", defaultValue = "0") String subTwo){
        return String.valueOf(Integer.getInteger(subOne) - Integer.getInteger(subTwo));
    }

    @GetMapping("/random")
    public String random(){
        rand = new Random().nextInt(10000);
        logger.log(Level.INFO, "Calculated random : " + Integer.toString(rand) );
        return String.valueOf(rand);
    }

}
