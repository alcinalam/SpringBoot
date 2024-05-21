package com.bc2403sb.democalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.DemoCalculatorApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class BeanController {
  
  @GetMapping(value ="/beans")
  public String[] getBeans(){
    return DemoCalculatorApplication.getContext().getBeanDefinitionNames();
  }
  
  
}
