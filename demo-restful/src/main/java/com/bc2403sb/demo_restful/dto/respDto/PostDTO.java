package com.bc2403sb.demo_restful.dto.respDto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {

  private int userId;
  private int PostId;
  private String postTitle;
  private String postBody;
  
}
