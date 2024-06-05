package com.bc2403sb.bc_forum.model;

import lombok.Getter;

@Getter
public class Comment {
  
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;

}
