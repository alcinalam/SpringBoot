package com.bc2403sb.democalculator.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.model.Cat;
import com.bc2403sb.democalculator.model.Color;

@Controller
@ResponseBody
public class CatController {

  // Java method returns Java object(cat)
  // Spring boot web layer (serialization - from java object to json)
  @GetMapping(value = "/cat/test")
  public Cat test() {
      return new Cat("abc",13,List.of(Color.RED));
  }

  // API return List<Cat>
  @GetMapping(value = "cats/test")
  public List<Cat> catTest() {
    return new ArrayList<>(List.of(new Cat("chan",12,List.of(Color.YELLOW,Color.BLACK)),(new Cat("ben",2,List.of(Color.RED,Color.BLACK)))));
  }

  // API return Cat[]
  @GetMapping(value = "cats/test/arr")
    public Cat[] catTestArr(){
      return new Cat[]{new Cat("ken",12,List.of(Color.RED,Color.WHITE)),new Cat ("bob",13,List.of(Color.YELLOW,Color.WHITE))} ;
    }
  


  

  
}
