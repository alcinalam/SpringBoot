package com.bc2403sb.bc_forum.dto.respDto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {

  private int userId;
  private int postId;
  private String postTitle;
  private String postBody;
  
}
