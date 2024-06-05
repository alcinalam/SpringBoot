package com.example.demo_exercise1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo_exercise1.model.Calculator;

@Configuration
public class AppConfig {
  
@Bean  (name = "calculator")
Calculator createCalculator(){
  return new Calculator();
}




}
