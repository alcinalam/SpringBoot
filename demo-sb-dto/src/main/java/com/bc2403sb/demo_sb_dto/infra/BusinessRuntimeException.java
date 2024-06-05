package com.bc2403sb.demo_sb_dto.infra;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException{

  private int code;

  public BusinessRuntimeException(SysCode sysCode) {
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }

}
