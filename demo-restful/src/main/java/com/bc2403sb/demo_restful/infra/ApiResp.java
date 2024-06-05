package com.bc2403sb.demo_restful.infra;

import java.util.Arrays;
import java.util.List;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ApiResp<T> {
  
  private int code;
  private String message;
  private List<T>data;

  public int getCode(){
    return this.code;
  }

  public String getmessage(){
    return this.message;
  }

  public List<T> getData(){
    return this.data;
  }

  public ApiResp(ApiRespBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  // static generic
  public static <T> ApiRespBuilder<T> builder() {
    return new ApiRespBuilder<>();
  }


  public static class ApiRespBuilder<T> {
    private int code;
    private String message;
    private List<T> data;

    public ApiRespBuilder<T> error(ErrorCode errorCode) {
      this.code = errorCode.getCode();
      this.message = errorCode.getDesc();
      return this;
    }

    public ApiRespBuilder<T> code(int code) {
      this.code = code;
      return this;
    }

    public ApiRespBuilder<T> message(String message) {
      this.message = message;
      return this;
    }

    public ApiRespBuilder<T> ok() {
      this.code = 0;
      this.message = "Success.";
      return this;
    }

    public ApiRespBuilder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
     return new ApiResp<>(this);
    }
  }


  public static void main(String[] args) {
    // Java 9
    List<String>strings = List.of ("abc","def");
    // better performance
    
    // Immutable;
    // strings.set(0,"hello");//java.lang.UnsupportedOperationException
    // strings.add("hello");//java.lang.UnsupportedOperationException
    // strings.remove(0);//java.lang.UnsupportedOperationException

    // input param -> (String ... str)
    Arrays.asList("abc","dec");
    List<String> string2 = Arrays.asList(new String[] {"abc", "def"});

    string2.set(0,"hello"); // OK, implies sorting is fine
    // string2.add("hello");//java.lang.UnsupportedOperationException
    // string2.remove(0);//java.lang.UnsupportedOperationException

    ApiResp<UserDTO> response = ApiResp.<UserDTO> builder() //
      .ok() // code = 0, message = "Success."
      .data(List.of(new UserDTO()))//
      .build();

    
    //new ArrayList<String>();
    //new LinkedList<>();
    // OK -> modify, add, remove, but too heavy for use, seldom need change data of API

    // Object ->JSON (Serialiaztion)
    // String json = "{ \"name\": \"Sally\"}";

    ObjectMapper objectMapper = new ObjectMapper();
    String json = "";
    try {
      json = objectMapper.writeValueAsString(response);
    } catch (JsonProcessingException e) {
     
    }
    System.out.println(json);
    //{"code":0,"message":"Success.","data":[{"id":0,"name":null,"address":null,"company":null}]}

  }
}
