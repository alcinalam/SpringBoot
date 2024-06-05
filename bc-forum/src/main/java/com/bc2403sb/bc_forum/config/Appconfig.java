package com.bc2403sb.bc_forum.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bc2403sb.bc_forum.model.Comment;
import com.bc2403sb.bc_forum.model.Post;
import com.bc2403sb.bc_forum.model.User;

@Configuration
public class Appconfig {
  
  @Bean (name = "restTemplate")
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean (name = "users")
  List<User> users() {
    return new ArrayList<>();
  } 

  @Bean (name = "posts")
  List<Post> posts() {
    return new ArrayList<>();
  } 

  @Bean (name = "comments")
  List<Comment> comments() {
    return new ArrayList<>();
  }   

}
