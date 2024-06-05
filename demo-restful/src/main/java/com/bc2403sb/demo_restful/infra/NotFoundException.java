package com.bc2403sb.demo_restful.infra;

import lombok.Getter;

@Getter
public class NotFoundException extends BusinessRuntimeException{

  public NotFoundException() {
    super(SysCode.NOT_FOUND);
    
  }


}
