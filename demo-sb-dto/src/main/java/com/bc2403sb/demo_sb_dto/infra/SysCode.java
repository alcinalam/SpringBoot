package com.bc2403sb.demo_sb_dto.infra;

import lombok.Getter;

@Getter
public enum SysCode {

  OK(0,"success."), //
  NOT_FOUND(1,"not found."),//
  USER_ID_NOT_FOUND(2,"User ID not found."),//
  LIST_ADD_FAIL(3,"List add fail"),
  ;

  private int code;
  private String desc;

  private SysCode (int code, String desc) {
    this.code = code;
    this.desc = desc;
  }


  

}
