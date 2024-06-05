package com.bc2403sb.demo_sb_dto.infra;


import java.io.IOException;
import java.util.ConcurrentModificationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.Getter;

// @RestControllerAdvice // @ ControllerAdvice + ResponseBody
public class GlobalExceptionHandler {
  // try to catch NotFoundException
  // if itis caught, call this java method, it passes the input parameter as well.

  @ExceptionHandler(NumberFormatException.class) //catch
  public ErrorResponse NumberFormatHandler(NumberFormatException e) {
    return new ErrorResponse(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  }

  // RunTimeException = NullPointerException
  // I/O Exception

  @ExceptionHandler(IllegalArgumentException.class) 
  public ErrorResponse IllegalArgumentExceptionHandler(IllegalArgumentException e) {
    return new ErrorResponse(98, "IllegalArgumentException.");
  }

  @ExceptionHandler(ArithmeticException.class) 
  public ErrorResponse ArithmeticExceptionHandler(ArithmeticException e) {
    return new ErrorResponse(ErrorCode.AE.getCode(),ErrorCode.AE.getDesc());
  }

  @ExceptionHandler(ArrayIndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(ArrayIndexOutOfBoundsException e) {
    return new ErrorResponse(96, "ArrayIndexOutOfBoundsException.");
  }

  @ExceptionHandler(NullPointerException.class) 
  public ErrorResponse notFoundExceptionHandler(NullPointerException e) {
    return new ErrorResponse(95, "NullPointerException.");
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(StringIndexOutOfBoundsException e) {
    return new ErrorResponse(94, "StringIndexOutOfBoundsException.");
  }

  @ExceptionHandler(IllegalStateException.class) 
  public ErrorResponse notFoundExceptionHandler(IllegalStateException e) {
    return new ErrorResponse(93, "IllegalStateException.");
  }

  @ExceptionHandler(ClassCastException.class) 
  public ErrorResponse notFoundExceptionHandler(ClassCastException e) {
    return new ErrorResponse(92, "ClassCastException.");
  }

  @ExceptionHandler(IndexOutOfBoundsException.class) 
  public ErrorResponse notFoundExceptionHandler(IndexOutOfBoundsException e) {
    return new ErrorResponse(91, "IndexOutOfBoundsException");
  }

  @ExceptionHandler(SecurityException.class) 
  public ErrorResponse notFoundExceptionHandler(SecurityException e) {
    return new ErrorResponse(90, "SecurityException");
  }

  @ExceptionHandler(UnsupportedOperationException.class) 
  public ErrorResponse notFoundExceptionHandler(UnsupportedOperationException e) {
    return new ErrorResponse(89, "UnsupportedOperationException");
  }

  @ExceptionHandler(ConcurrentModificationException.class) 
  public ErrorResponse notFoundExceptionHandler(ConcurrentModificationException e) {
    return new ErrorResponse(88, "ConcurrentModificationException");
  }

  @ExceptionHandler(IOException.class) 
  public ErrorResponse notFoundExceptionHandler(IOException e) {
    return new ErrorResponse(87, "I/OException");
  }

  // Alternative



  @Getter
  private enum ErrorCode {
    NPE(99,"Null Pointer Exception."),//
    NFE(98,"NumberFormat Exception."),
    AE (97,"ArithmeticException."),
    ;

    private int code;
    private String desc;
  
    private ErrorCode (int code, String desc) {
      this.code = code;
      this.desc = desc;
  }
}
}
