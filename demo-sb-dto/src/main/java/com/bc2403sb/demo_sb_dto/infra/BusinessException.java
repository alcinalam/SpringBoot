package com.bc2403sb.demo_sb_dto.infra;

import lombok.Getter;

@Getter
public class BusinessException extends Exception{

  private int code;

  public BusinessException(SysCode sysCode) {
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }
  
}
