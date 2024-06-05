package com.bc2403sb.demo_sb_dto.exceptions;


import com.bc2403sb.demo_sb_dto.infra.BusinessRuntimeException;
import com.bc2403sb.demo_sb_dto.infra.SysCode;

public class UserNotFoundException extends BusinessRuntimeException {
  
  public UserNotFoundException() {
    super(SysCode.USER_ID_NOT_FOUND);
  }
}
