package com.bc2403sb.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.bc_forum.dto.respDto.CommentDTO;
import com.bc2403sb.bc_forum.model.Comment;

@Component
public class CommentMapper {
  
  public CommentDTO commentToMap (Comment comment) {

    return CommentDTO.builder() //
      .postId(comment.getPostId()) //
      .id(comment.getId())//
      .name(comment.getName())//
      .email(comment.getEmail())//
      .build();
  }
}
