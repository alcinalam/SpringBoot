package com.bc2403sb.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.bc_forum.controller.PostOperation;
import com.bc2403sb.bc_forum.dto.respDto.PostDTO;
import com.bc2403sb.bc_forum.mapper.PostMapper;
import com.bc2403sb.bc_forum.service.PostService;

@RestController
public class PostController implements PostOperation {
  @Autowired
  private PostService postService;

  @Autowired
  private PostMapper postMapper;

  @Override
  public List<PostDTO> getPosts() {
    return postService.getPosts().stream()//
      .map(e-> postMapper.postToMap(e)) //
      .collect(Collectors.toList());
  }


}
