package com.example.demo_exercise1.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo_exercise1.infra.GlobalExceptionHandler;

@RestControllerAdvice
public class LocalExceptionHandler extends GlobalExceptionHandler {
  
}
