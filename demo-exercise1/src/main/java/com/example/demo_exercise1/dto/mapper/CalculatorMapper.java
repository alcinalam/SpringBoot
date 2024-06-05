package com.example.demo_exercise1.dto.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo_exercise1.dto.CalculatorDTO;
import com.example.demo_exercise1.model.Calculator;
import com.example.demo_exercise1.service.CalculatorService;

@Component
public class CalculatorMapper {

  @Autowired
  CalculatorService calculatorService;
  
  public CalculatorDTO mapToCalculatorDTO (Calculator calculator) {
    return CalculatorDTO.builder() //
      .x(calculator.getX()) //
      .y(calculator.getY()) //
      .op(calculator.getOp())//
      .build();
  }  
}
