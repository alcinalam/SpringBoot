package com.bc2403sb.demo_sb_dto.exceptions;


import com.bc2403sb.demo_sb_dto.infra.BusinessRuntimeException;
import com.bc2403sb.demo_sb_dto.infra.SysCode;

public class ListAddException extends BusinessRuntimeException {

  public ListAddException (){
    super(SysCode.LIST_ADD_FAIL);
  }
  
}
