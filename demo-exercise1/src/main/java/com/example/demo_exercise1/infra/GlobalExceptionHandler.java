package com.example.demo_exercise1.infra;


import java.io.IOException;
import java.util.ConcurrentModificationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;

// @RestControllerAdvice // @ ControllerAdvice + ResponseBody
public class GlobalExceptionHandler {
  // try to catch NotFoundException
  // if itis caught, call this java method, it passes the input parameter as well.

  @ExceptionHandler(NumberFormatException.class) //catch
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse NumberFormatHandler(NumberFormatException e) {
    return new ErrorResponse(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  }

  // RunTimeException = NullPointerException
  // I/O Exception

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) 
  public ErrorResponse IllegalArgumentExceptionHandler(IllegalArgumentException e) {
    return new ErrorResponse(ErrorCode.IAE.getCode(), ErrorCode.IAE.getDesc());
  }

  @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) 
  public ErrorResponse ArithmeticExceptionHandler(ArithmeticException e) {
    return new ErrorResponse(ErrorCode.AE.getCode(),ErrorCode.AE.getDesc());
  }

  @ExceptionHandler(ArrayIndexOutOfBoundsException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(ArrayIndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.IAE.getCode(), ErrorCode.IAE.getDesc());
  }

  @ExceptionHandler(NullPointerException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(NullPointerException e) {
    return new ErrorResponse(ErrorCode.NPE.getCode(), ErrorCode.NFE.getDesc());
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(StringIndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.SIOOB.getCode(), ErrorCode.SIOOB.getDesc());
  }

  @ExceptionHandler(IllegalStateException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(IllegalStateException e) {
    return new ErrorResponse(ErrorCode.ISE.getCode(), ErrorCode.ISE.getDesc());
  }

  @ExceptionHandler(ClassCastException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(ClassCastException e) {
    return new ErrorResponse(ErrorCode.CCE.getCode(), ErrorCode.CCE.getDesc());
  }

  @ExceptionHandler(IndexOutOfBoundsException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(IndexOutOfBoundsException e) {
    return new ErrorResponse(ErrorCode.IOOB.getCode(), ErrorCode.IOOB.getDesc());
  }

  @ExceptionHandler(SecurityException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(SecurityException e) {
    return new ErrorResponse(ErrorCode.SE.getCode(), ErrorCode.SE.getDesc());
  }

  @ExceptionHandler(UnsupportedOperationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) 
  public ErrorResponse notFoundExceptionHandler(UnsupportedOperationException e) {
    return new ErrorResponse(ErrorCode.UOE.getCode(), ErrorCode.UOE.getDesc());
  }

  @ExceptionHandler(ConcurrentModificationException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(ConcurrentModificationException e) {
    return new ErrorResponse(ErrorCode.CME.getCode(), ErrorCode.CME.getDesc());
  }

  @ExceptionHandler(IOException.class) 
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(IOException e) {
    return new ErrorResponse(ErrorCode.IOE.getCode(), ErrorCode.IOE.getDesc());
  }

  // Alternative



  @Getter
  private enum ErrorCode {
    NPE(99,"Null Pointer Exception."),//
    NFE(98,"NumberFormat Exception."),
    AE (97,"ArithmeticException."),
    IAE (96,"IllegalArgumentException."),//
    AIOOB(95,"ArrayIndexOutOfBoundsException."),//
    SIOOB(94,"StringIndexOutOfBoundsException."),//
    ISE(93, "IllegalStateException."),//
    CCE(92, "ClassCastException."),//
    IOOB(91, "IndexOutOfBoundsException"),//
    SE(90, "SecurityException"),//
    UOE(89, "UnsupportedOperationException"),//
    CME(88, "ConcurrentModificationException"),//
    IOE(87, "I/OException"),//
    ;

    private int code;
    private String desc;
  
    private ErrorCode (int code, String desc) {
      this.code = code;
      this.desc = desc;
  }
}
}
