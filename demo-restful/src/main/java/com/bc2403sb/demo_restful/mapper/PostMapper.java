package com.bc2403sb.demo_restful.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.demo_restful.dto.respDto.PostDTO;
import com.bc2403sb.demo_restful.model.dto.Post;

@Component
public class PostMapper {

  public PostDTO postToMap (Post post) {
    
    return PostDTO.builder() //
    .userId(post.getUserId()) //
    .PostId(post.getId()) //
    .postTitle(post.getTitle()) //
    .postBody(post.getBody())//
    .postTitle(post.getTitle())//
    .build();
  }
  
}
