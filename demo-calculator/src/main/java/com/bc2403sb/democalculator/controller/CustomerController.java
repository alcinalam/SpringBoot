package com.bc2403sb.democalculator.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.model.Address;
import com.bc2403sb.democalculator.model.Customer;
import com.bc2403sb.democalculator.model.Order;

@Controller
@ResponseBody
public class CustomerController {
  
  @GetMapping(value = "orders")
  public List<Customer> customerOrder(){
    List<Customer> customerOrders = new ArrayList<>();
    Address a =  new Address("12345", "abcd", "Kowloon");
    Address b =  new Address("12345", "abcd", "Kowloon");
    Address c =  new Address("12345", "abcd", "Kowloon");
    Order o1 = new Order(1, a);
    Order o2 = new Order(2, b);
    Order o3 = new Order(3, c);
    List<Order> l1 = new ArrayList<>();
    l1.add(o1);
    List<Order> l2 = new ArrayList<>();
    l2.add(o2);
    l2.add(o3);
    customerOrders.add(new Customer("Kelly", LocalDate.of(2023,3,4), l1));
    customerOrders.add(new Customer("Jelly", LocalDate.of(2029,3,4), l2));
    return customerOrders;


  }



}