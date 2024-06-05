package com.bc2403sb.democalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.democalculator.model.Cat;

public interface TestOperation {
  
  @GetMapping(value = "/hello")
  String testSayHello();

  @GetMapping(value = "/hello2")
  String testSayHello2();

  @GetMapping(value = "/hello3")
  String testSayHello3();

  @GetMapping(value = "/whitecat")
  Cat getWhiteCat();

}
