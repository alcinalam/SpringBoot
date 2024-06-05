package com.bc2403sb.demo_sb_dto.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bc2403sb.demo_sb_dto.infra.GlobalExceptionHandler;


@RestControllerAdvice
public class LocalGlobalExceptionHandler extends GlobalExceptionHandler{
  
  //   @ExceptionHandler(BusinessRuntimeException.class) // catch 
  //   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  // public ErrorResponse BusinessRuntimeExceptionHandler(BusinessRuntimeException e) {
  //   return new ErrorResponse(e.getCode(), e.getMessage());
  // }

}
