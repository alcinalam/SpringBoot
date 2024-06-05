package com.bc2403sb.demo_sb_dto.dto.mapper;


import org.springframework.stereotype.Component;
import com.bc2403sb.demo_sb_dto.dto.StockDTO;
import com.bc2403sb.demo_sb_dto.model.Stock;

@Component // create bean to container
public class StockMapper {
  

  public StockDTO mapToStockDTO(Stock stock) {
    return StockDTO.builder() //
      .stockNo(stock.getId()) //
      .quantity(stock.getQuantity()) //
      .build();
  }

}
