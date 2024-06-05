package com.bc2403sb.restful.exceptions;

import com.bc2403sb.restful.infra.BusinessRuntimeException;
import com.bc2403sb.restful.infra.SysCode;


public class NotFoundException extends BusinessRuntimeException {
    public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }
}
