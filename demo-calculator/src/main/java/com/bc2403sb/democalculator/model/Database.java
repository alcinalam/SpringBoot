package com.bc2403sb.democalculator.model;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Database {
   public final static HashMap<String,Integer> map = new HashMap<>();
   private String name;
   private int age;
}
