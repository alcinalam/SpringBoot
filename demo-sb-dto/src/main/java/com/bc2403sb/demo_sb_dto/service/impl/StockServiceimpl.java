package com.bc2403sb.demo_sb_dto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bc2403sb.demo_sb_dto.config.AppConfig;
import com.bc2403sb.demo_sb_dto.exceptions.ListAddException;
import com.bc2403sb.demo_sb_dto.exceptions.UserNotFoundException;
import com.bc2403sb.demo_sb_dto.infra.NotFoundException;
import com.bc2403sb.demo_sb_dto.model.Stock;
import com.bc2403sb.demo_sb_dto.model.User;
import com.bc2403sb.demo_sb_dto.service.StockService;


@Service
public class StockServiceimpl implements StockService {

  @Autowired
  private AppConfig appConfig;
  
  @Override
  public List<Stock> getAll() {
    return appConfig.getUsers().stream() //
        .flatMap(e -> e.getStocks().stream()) //
        .collect(Collectors.toList());
  }

  @Override
  public Stock getById(int stockId) throws NotFoundException {
    return this.getAll().stream() //
      .filter(e -> e.getId() == stockId) //
      .findFirst() //
      .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public Stock save(Stock stock, int userId) {
    // user id not found
    // add stock -> fail
    User user = appConfig.getUsers().stream() //
      .filter(e-> e.getId() == userId) //
      .findAny() //
      .orElseThrow(() -> new UserNotFoundException());
      
    if(user.add(stock))  
      return stock;
    throw new ListAddException();
  }

  public Stock demoResponseEntity(String id) {
    if (id.length() == 2)
      return new Stock(1,"CDE",2000);
    throw new IllegalArgumentException();

  }
}