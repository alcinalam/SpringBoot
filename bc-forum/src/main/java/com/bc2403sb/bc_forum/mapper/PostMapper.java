package com.bc2403sb.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.bc_forum.dto.respDto.PostDTO;
import com.bc2403sb.bc_forum.model.Post;


@Component
public class PostMapper {

  public PostDTO postToMap (Post post) {
    
    return PostDTO.builder() //
    .userId(post.getUserId()) //
    .postId(post.getId()) //
    .postTitle(post.getTitle()) //
    .postBody(post.getBody())//
    .postTitle(post.getTitle())//
    .build();
  }
  
}
