package com.bc2403sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.bc_forum.dto.respDto.CommentDTO;



public interface CommentOperation {

  @GetMapping(value = "/jsonplaceholder/comments")
  List<CommentDTO> getComments();

}
