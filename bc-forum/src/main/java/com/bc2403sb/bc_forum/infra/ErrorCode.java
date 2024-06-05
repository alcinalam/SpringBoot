package com.bc2403sb.bc_forum.infra;


public enum ErrorCode {
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

    public int getCode(){
      return this.code;
    }

    public String getDesc(){
      return this.desc;
    }
}
