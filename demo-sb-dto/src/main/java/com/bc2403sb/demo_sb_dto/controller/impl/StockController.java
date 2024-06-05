package com.bc2403sb.demo_sb_dto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.demo_sb_dto.controller.StockOperation;
import com.bc2403sb.demo_sb_dto.dto.StockDTO;
import com.bc2403sb.demo_sb_dto.dto.mapper.StockMapper;
import com.bc2403sb.demo_sb_dto.infra.NotFoundException;
import com.bc2403sb.demo_sb_dto.model.Stock;
import com.bc2403sb.demo_sb_dto.service.StockService;
import com.bc2403sb.demo_sb_dto.service.impl.StockServiceimpl;


@RestController
public class StockController implements StockOperation{

  @Autowired
  private StockService stockService;

  @Autowired
  private StockMapper stockMapper;

  @Override
  public List<StockDTO> getStocks(){
    return stockService.getAll().stream() //
      .collect(Collectors.groupingBy(e -> e.getId(),
        Collectors.summingInt(e -> e.getQuantity()))) // Map.class
      .entrySet().stream() //
      .map(e -> new StockDTO(e.getKey(),e.getValue()))
      .collect(Collectors.toList());
  }

  @Override
  public Stock getStockById(String id) throws NotFoundException{
    
      // try catch may need catch two
      // int stockId = Integer.parseInt(id);
      // Stock stock = stockService.getById(stockId);

      Stock stock = stockService.getById(Integer.parseInt(id));

      return stock;

  }


  @Override
    public Stock saveStock(Stock stock, int userId ){
      return stockService.save(stock, userId);
    }

  // Demo RespoinseEntity<>
  @GetMapping(value = "/test/{id}")
  public ResponseEntity<Stock> demoResponseEntity(@PathVariable String id) {
    Stock stock = null;
    try {
      stock = new StockServiceimpl().demoResponseEntity(id);
      return ResponseEntity.ok().body(stock);
  } catch (IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(new Stock(99,"zzz",1000));
  }

 }
}
