package com.bc2403sb.demo_restful.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bc2403sb.demo_restful.infra.GlobalExceptionHandler;

@RestControllerAdvice
public class LocalExceptionHandler extends GlobalExceptionHandler {
  
}
