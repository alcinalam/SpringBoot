package com.bc2403sb.democalculator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bc2403sb.democalculator.model.Database;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@ResponseBody
public class DatabaseContoller {
  // belong to Class
  private final static int[] database = new int[]{10,-3,9};
 


  // Design an API, get the value from array by index
  // index range: if /try catch
  @GetMapping(value = "database/value/{index}") //
  public String get(@PathVariable String index) {
    try {
      int idx = Integer.parseInt(index);
      return String.valueOf(database[idx]);
    } catch (NumberFormatException e) {
      return "the index should be an integer value.";
    } catch (ArrayIndexOutOfBoundsException e) {
      return "the index is out of range of the array size";
    }
  }


  // API sorting
  // stream
  @GetMapping (value = "database/sorting")
  public void sort(){
   Comparator<Integer> descending = (i1,i2) -> i1.compareTo(i2) > 0 ? -1:1;
  
    int[] newArr = Arrays.stream(database) //
      .boxed()
      .sorted(descending) // 
      .mapToInt(Integer::intValue) //e->e.intValue()
      .toArray();

    for (int i = 0; i < database.length; i++){
      database[i] = newArr[i];

    }  
  }
   
  // API: return the array

  @GetMapping(value="database/sort/output")
  public int[] getSort () {
  int[] newArr = Arrays.stream(database)//
      .boxed()
      .sorted()//
      .mapToInt(Integer::intValue)
      .toArray();

  return newArr;

  }
  
  
  
  
  @GetMapping(value = "database/age/map/{name}/{age}")
  public HashMap<String,Integer> addInAge(@PathVariable String name,@PathVariable int age) {
    Database.map.put(name, age);
    return Database.map;
   }

   // no static resource
   @GetMapping(value ="database/age")
   public HashMap<String,Integer> getMap() {
      return Database.map;
   }
   


 
}
