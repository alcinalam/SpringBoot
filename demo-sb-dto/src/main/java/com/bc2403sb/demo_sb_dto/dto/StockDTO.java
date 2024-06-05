package com.bc2403sb.demo_sb_dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// DTO stands for Data transfer Object
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDTO {
  private int stockNo;
  private int quantity;

}
