package com.example.demo_exercise1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.example.demo_exercise1.model.Operations;
import com.example.demo_exercise1.service.CalculatorService;

@Service
public class CalculatorsServiceimpl implements CalculatorService {


  @Override
  public Double add(String x, String y) {
    return BigDecimal.valueOf(Double.valueOf(x))//
        .add(BigDecimal.valueOf(Double.valueOf(y)))//
        .doubleValue();
  }

  @Override
  public Double sub(String x, String y) {
    return BigDecimal.valueOf(Double.valueOf(x))//
    .subtract(BigDecimal.valueOf(Double.valueOf(y)))//
    .doubleValue();
  }

  @Override
  public Double mul(String x, String y) {
    return BigDecimal.valueOf(Double.valueOf(x))//
    .multiply(BigDecimal.valueOf(Double.valueOf(y)))//
    .doubleValue();
  }

  @Override
  public Double div(String x, String y)  {
    if (Double.parseDouble(y) == 0){
      throw new ArithmeticException("Cannot divide by Zero");
    }
    return BigDecimal.valueOf(Double.valueOf(x))//
    .divide(BigDecimal.valueOf(Double.valueOf(y)),5,RoundingMode.HALF_UP)//
    .doubleValue();
  }

  
  @Override
  public String getResult(String x, String y, String op) {
    
    Operations operation = Operations.valueOf(op.toUpperCase());
    switch(operation) {
      case ADD:
        return String.valueOf(add(x, y));
      case SUB:
        return String.valueOf(sub(x, y));
      case MUL:
        return String.valueOf(mul(x, y));
      case DIV:
        return String.valueOf(div(x, y));
      default:
        throw new IllegalArgumentException();
      
    }
  }


}
