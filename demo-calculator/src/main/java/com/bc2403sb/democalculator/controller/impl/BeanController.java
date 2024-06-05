package com.bc2403sb.democalculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.DemoCalculatorApplication;
import com.bc2403sb.democalculator.controller.BeanOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class BeanController implements BeanOperation{
  
  @Override
  @GetMapping(value ="/beans")
  public String[] getBeans(){
    return DemoCalculatorApplication.getContext().getBeanDefinitionNames();
  }
  
  
}
