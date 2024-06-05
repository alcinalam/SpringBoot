package com.example.demo_exercise1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo_exercise1.dto.CalculatorDTO;
import com.example.demo_exercise1.model.Calculator;

public interface CalculatorOperation {
  
  @GetMapping(value = "/calculate/{x}/{y}/{op}")
  CalculatorDTO calResult(//
    @PathVariable String x, //
    @PathVariable String y,//
    @PathVariable String op);


  @PostMapping(value = "/calculatepost")
  @ResponseStatus(value = HttpStatus.CREATED)
  Calculator calPost(@RequestBody Calculator calculator);


}
