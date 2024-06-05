package com.bc2403sb.demo_sb_dto.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class User {

  public static int count = 0;
  
  private int id;
  private List<Stock> stocks;

  public User(){
    this.id = ++count;
    stocks = new ArrayList<>();
  }

  public boolean add(Stock stock){
    return this.stocks.add(stock);
  }


}
