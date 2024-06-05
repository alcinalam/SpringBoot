package com.example.demo_exercise1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculatorDTO {
  private String x;
  private String y;
  private String op;
  private String result;
}
