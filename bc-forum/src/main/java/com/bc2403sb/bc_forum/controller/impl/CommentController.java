package com.bc2403sb.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.bc_forum.controller.CommentOperation;
import com.bc2403sb.bc_forum.dto.respDto.CommentDTO;
import com.bc2403sb.bc_forum.mapper.CommentMapper;
import com.bc2403sb.bc_forum.service.CommentService;

@RestController
public class CommentController implements CommentOperation{


  @Autowired
  private CommentService commentService;

  @Autowired
  private CommentMapper commentMapper;


  @Override
  public List<CommentDTO> getComments() {
    return commentService.getComments().stream()//
      .map(e->commentMapper.commentToMap(e)) //
      .collect(Collectors.toList());
    
  }
  
}
