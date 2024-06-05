package com.bc2403sb.demo_sb_dto.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bc2403sb.demo_sb_dto.dto.StockDTO;
import com.bc2403sb.demo_sb_dto.infra.NotFoundException;
import com.bc2403sb.demo_sb_dto.model.Stock;



public interface StockOperation {
  @GetMapping(value = "/stocks") // getsth
  @ResponseStatus(value = HttpStatus.OK)
  List<StockDTO> getStocks();

  @GetMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock getStockById(@RequestParam String id) throws NotFoundException;

  @PostMapping(value = "/stock") // insert sth
  @ResponseStatus(value = HttpStatus.OK)
  Stock saveStock(@RequestBody Stock stock, @RequestParam int userId);
}
