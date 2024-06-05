package com.bc2403sb.democalculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.config.AppConfig;
import com.bc2403sb.democalculator.config.AppConfig2;
import com.bc2403sb.democalculator.controller.TestOperation;
import com.bc2403sb.democalculator.model.Cat;

@Controller
@ResponseBody
public class TestController implements TestOperation {

  @Autowired // Find the appConfig object (bean) from spring context, and then inject to this object ref
  private AppConfig appConfig;

  // Spring cannot find the appConfig2 object, inject fail
  // but required = false, so the server can start normally
  @Autowired(required = false)
  private AppConfig2 appConfig2;

  // Implication: testController object depends on cat object
  @Autowired
  @Qualifier(value = "yellow") // inject the object by bean name
  private Cat cat;

  @Override
  public String testSayHello() {
    return new AppConfig().sayHello();
  }

  @Override
  public String testSayHello2() {
    return appConfig.sayHello();
    // if (appConfig == appConfig2) // object reference
    //   return "Yes";
    // return "No";
  }

  @Override
  public String testSayHello3() {
    return appConfig2.sayHello(); // NPE if @Autowired(required = false)
  }

  @Override
  public Cat getWhiteCat() {
    return this.cat;
  }

}
