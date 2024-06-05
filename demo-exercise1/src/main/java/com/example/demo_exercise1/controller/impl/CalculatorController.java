package com.example.demo_exercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_exercise1.controller.CalculatorOperation;
import com.example.demo_exercise1.dto.CalculatorDTO;
import com.example.demo_exercise1.dto.mapper.CalculatorMapper;
import com.example.demo_exercise1.model.Calculator;
import com.example.demo_exercise1.service.CalculatorService;




@RestController
public class CalculatorController implements CalculatorOperation {


  @Autowired
  private CalculatorMapper calculatorMapper;

  @Autowired
  private CalculatorService calculatorService;
  
  @Autowired
  private Calculator calculator;

  @Override
  public CalculatorDTO calResult(String x, String y,String op) {
    
    calculator.setX(x);
    calculator.setY(y);
    calculator.setOp(op);
    
    String result = calculatorService.getResult(x, y, op);
    
    CalculatorDTO calculatorDTO = calculatorMapper.mapToCalculatorDTO(calculator);
    calculatorDTO.setResult(result);
    
    return calculatorDTO;
  }

  @Override
  public Calculator calPost(Calculator calculator) {
    return new Calculator(calculator.getX(),calculator.getY(),calculator.getOp());

  }



  
}
