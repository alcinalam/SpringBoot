package com.bc2403sb.demo_sb_dto.service;

import java.util.List;
import com.bc2403sb.demo_sb_dto.infra.NotFoundException;
import com.bc2403sb.demo_sb_dto.model.Stock;




public interface StockService {
  
  List<Stock> getAll();

  Stock getById(int stockId) throws NotFoundException;

  Stock save(Stock stock, int userId);



}
