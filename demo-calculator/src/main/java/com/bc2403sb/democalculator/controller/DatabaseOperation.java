package com.bc2403sb.democalculator.controller;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DatabaseOperation {
  
@GetMapping(value = "database/value/{index}") //
String get(@PathVariable String index);

@GetMapping (value = "database/sorting")
void sort();


@GetMapping(value="database/sort/output")
int[] getSort ();


@GetMapping(value = "database/age/map/{name}/{age}")
HashMap<String,Integer> addInAge(@PathVariable String name,@PathVariable int age);

@GetMapping(value ="database/age")
HashMap<String,Integer> getMap();

}
