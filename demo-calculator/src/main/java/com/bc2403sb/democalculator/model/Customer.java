package com.bc2403sb.democalculator.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
  private String name;
  private LocalDate date;
  private List<Order> order;
  
}
