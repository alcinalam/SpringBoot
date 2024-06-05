package com.bc2403sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.bc_forum.dto.respDto.PostDTO;


public interface PostOperation {

  @GetMapping(value = "/jsonplaceholder/posts")
  List<PostDTO> getPosts();
  
}
