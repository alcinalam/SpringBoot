package com.bc2403sb.demohelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class HelloworldController {
  
  // API 接口 (Application Programming interface)
  @GetMapping(value = "a1/hello") // URI -> resource identifier
  public String hello () {
    return "hello world!";
  }

  @GetMapping(value = "a2/hello") // URI -> resource identifier
  public String hello2 () {
    return "hello world 2!";
  }
  
 

  public static void main(String[] args) {
    HelloworldController hc = new HelloworldController();
    System.out.println(hc.hello());
  }
}
