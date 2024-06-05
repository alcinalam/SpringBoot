package com.bc2403sb.demo_sb_dto.infra;

import lombok.Getter;

@Getter
public class NotFoundException extends BusinessException{

  public NotFoundException() {
    super(SysCode.NOT_FOUND);
    
  }


}
