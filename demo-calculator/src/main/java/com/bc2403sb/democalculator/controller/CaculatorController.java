package com.bc2403sb.democalculator.controller;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CaculatorController {
  
  // 
  @GetMapping(value = "/sum/{a}/{b}")
  public int sum(@PathVariable(value = "a" ) int salary,
  @PathVariable(value = "b") int bonus) {
    return salary + bonus;
  }

  // we can achieve default mapping by name,
  // if you do not explictly define PathVariable
  @GetMapping("subtract/{salary}/{bonus}")
  public int subtract(@PathVariable int salary,@PathVariable int bonus){
    return salary - bonus;
  }
    
  @GetMapping(value = "/multiply") //mulitply?a=10&b=11 (localhost)
  public int multiply(@RequestParam(value = "a") int quantity,
  @RequestParam(value = "b") int price){
    return quantity * price;
  }

  @GetMapping(value = "/divide") //divided?a=10&b=11 (localhost)
  public int divide(@RequestParam int quantity,
  @RequestParam int price){
    return quantity/price;
  }

  @GetMapping(value = "/sum/double")
  public String sum2(@RequestParam String q, @RequestParam String p) {
    double q2 =0.0d;
    double p2 =0.0d;
    try {
       p2 = Double.parseDouble(p);
       q2 = Double.parseDouble(q);
    } catch (NumberFormatException e) {
      return "Both q and q should be numbers.";
    }
    return BigDecimal.valueOf(q2).add(BigDecimal.valueOf(p2)).toString();
  }


}
