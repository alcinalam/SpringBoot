package com.bc2403sb.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.democalculator.model.Cat;

public interface CatOperation {
  
  @GetMapping(value = "/cat/test")
  Cat test();

  @GetMapping(value = "cats/test")
  List<Cat> catTest();

  @GetMapping(value = "cats/test/arr")
  Cat[] catTestArr();
}
