package com.bc2403sb.demo_restful.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
  private int code;
  private String message;

  public static ErrorResponse of (int code, String message) {
    return new ErrorResponse(code, message);
  }
}
