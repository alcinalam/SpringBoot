package com.example.demo_exercise1.service;



public interface CalculatorService {
  
  Double add(String x, String y);
  Double sub(String x, String y);
  Double mul(String x, String y);
  Double div(String x, String y);

  String getResult(String x, String y, String op) ;

}
