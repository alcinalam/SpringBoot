package com.bc2403sb.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc2403sb.democalculator.model.Customer;
import com.bc2403sb.democalculator.model.Student;

public interface CustomerOperation {
  

 @GetMapping(value = "/orders")
 List<Customer> customerOrder();

}
