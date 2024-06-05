package com.bc2403sb.bc_forum.dto.respDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {
  private int postId;
  private int id;
  private String name;
  private String email;
}
