package com.bc2403sb.restful.infra;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionHandler {
  @ExceptionHandler(NumberFormatException.class) //catch
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> NumberFormatHandler(NumberFormatException e) {
    //return new ErrorResponse(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
    return ApiResp.<Void>builder()//
      .error(ErrorCode.NFE)//
      .build();
  }

  // RunTimeException = NullPointerException
  // I/O Exception

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> IllegalArgumentExceptionHandler(IllegalArgumentException e) {
    //return ErrorResponse.of(ErrorCode.IAE.getCode(), ErrorCode.IAE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.IAE)//
    .build();
  }

  @ExceptionHandler(ArithmeticException.class) 
  public ApiResp<Void>ArithmeticExceptionHandler(ArithmeticException e) {
    //return new ErrorResponse(ErrorCode.AE.getCode(),ErrorCode.AE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.AE)//
    .build();
  }

  @ExceptionHandler(NullPointerException.class) 
  public ApiResp<Void> notFoundExceptionHandler(NullPointerException e) {
    //return new ErrorResponse(ErrorCode.NPE.getCode(), ErrorCode.NFE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.NPE)//
    .build();
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class) 
  public ApiResp<Void> notFoundExceptionHandler(StringIndexOutOfBoundsException e) {
    //return new ErrorResponse(ErrorCode.SIOOB.getCode(), ErrorCode.SIOOB.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.SIOOB)//
    .build();
  }

  @ExceptionHandler(IllegalStateException.class) 
  public ApiResp<Void> notFoundExceptionHandler(IllegalStateException e) {
    //return new ErrorResponse(ErrorCode.ISE.getCode(), ErrorCode.ISE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.ISE)//
    .build();
  }

  @ExceptionHandler(ClassCastException.class) 
  public ApiResp<Void> notFoundExceptionHandler(ClassCastException e) {
    //return new ErrorResponse(ErrorCode.CCE.getCode(), ErrorCode.CCE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.CCE)//
    .build();
  }

  @ExceptionHandler(IndexOutOfBoundsException.class) 
  public ApiResp<Void> notFoundExceptionHandler(IndexOutOfBoundsException e) {
    //return new ErrorResponse(ErrorCode.IOOB.getCode(), ErrorCode.IOOB.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.IOOB)//
    .build();
  }

  @ExceptionHandler(SecurityException.class) 
  public ApiResp<Void> notFoundExceptionHandler(SecurityException e) {
    //return new ErrorResponse(ErrorCode.SE.getCode(), ErrorCode.SE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.SE)//
    .build();
  }

  @ExceptionHandler(UnsupportedOperationException.class) 
  public ApiResp<Void> notFoundExceptionHandler(UnsupportedOperationException e) {
    //return new ErrorResponse(ErrorCode.UOE.getCode(), ErrorCode.UOE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.UOE)//
    .build();
  }

  @ExceptionHandler(ConcurrentModificationException.class) 
  public ApiResp<Void> notFoundExceptionHandler(ConcurrentModificationException e) {
    //return new ErrorResponse(ErrorCode.CME.getCode(), ErrorCode.CME.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.CME)//
    .build();
  }

  @ExceptionHandler(IOException.class) 
  public ApiResp<Void> notFoundExceptionHandler(IOException e) {
    //return new ErrorResponse(ErrorCode.IOE.getCode(), ErrorCode.IOE.getDesc());
    return ApiResp.<Void>builder()//
    .error(ErrorCode.IOE)//
    .build();
  }
}
