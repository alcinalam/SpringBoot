package com.bc2403sb.bc_forum.infra;


import java.io.IOException;
import java.util.ConcurrentModificationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


// @RestControllerAdvice // @ ControllerAdvice + ResponseBody
public class GlobalExceptionHandler {
  // try to catch NotFoundException
  // if itis caught, call this java method, it passes the input parameter as well.

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
  public ErrorResponse IllegalArgumentExceptionHandler(IllegalArgumentException e) {
    return new ErrorResponse(ErrorCode.IAE.getCode(), ErrorCode.IAE.getDesc());
  }

  @ExceptionHandler(ArithmeticException.class) 
  public ErrorResponse ArithmeticExceptionHandler(ArithmeticException e) {
    return new ErrorResponse(ErrorCode.AE.getCode(),ErrorCode.AE.getDesc());
  }

  @ExceptionHandler(ArrayIndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(ArrayIndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.IAE.getCode(), ErrorCode.IAE.getDesc());
  }

  @ExceptionHandler(NullPointerException.class) 
  public ErrorResponse notFoundExceptionHandler(NullPointerException e) {
    return new ErrorResponse(ErrorCode.NPE.getCode(), ErrorCode.NFE.getDesc());
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(StringIndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.SIOOB.getCode(), ErrorCode.SIOOB.getDesc());
  }

  @ExceptionHandler(IllegalStateException.class) 
  public ErrorResponse notFoundExceptionHandler(IllegalStateException e) {
    return new ErrorResponse(ErrorCode.ISE.getCode(), ErrorCode.ISE.getDesc());
  }

  @ExceptionHandler(ClassCastException.class) 
  public ErrorResponse notFoundExceptionHandler(ClassCastException e) {
    return new ErrorResponse(ErrorCode.CCE.getCode(), ErrorCode.CCE.getDesc());
  }

  @ExceptionHandler(IndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(IndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.IOOB.getCode(), ErrorCode.IOOB.getDesc());
  }

  @ExceptionHandler(SecurityException.class) 
  public ErrorResponse notFoundExceptionHandler(SecurityException e) {
    return new ErrorResponse(ErrorCode.SE.getCode(), ErrorCode.SE.getDesc());
  }

  @ExceptionHandler(UnsupportedOperationException.class) 
  public ErrorResponse notFoundExceptionHandler(UnsupportedOperationException e) {
    return new ErrorResponse(ErrorCode.UOE.getCode(), ErrorCode.UOE.getDesc());
  }

  @ExceptionHandler(ConcurrentModificationException.class) 
  public ErrorResponse notFoundExceptionHandler(ConcurrentModificationException e) {
    return new ErrorResponse(ErrorCode.CME.getCode(), ErrorCode.CME.getDesc());
  }

  @ExceptionHandler(IOException.class) 
  public ErrorResponse notFoundExceptionHandler(IOException e) {
    return new ErrorResponse(ErrorCode.IOE.getCode(), ErrorCode.IOE.getDesc());
  }

  // @ExceptionHandler(Exception.class) 
  // public ErrorResponse unhandledException() {
  //   return new ErrorResponse(9999, "Other unhandled exception.");
  // }

  // Alternative



  
}
