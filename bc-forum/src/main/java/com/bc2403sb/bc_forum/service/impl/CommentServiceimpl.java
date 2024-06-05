package com.bc2403sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bc2403sb.bc_forum.infra.Scheme;
import com.bc2403sb.bc_forum.model.Comment;

import com.bc2403sb.bc_forum.service.CommentService;

@Service
public class CommentServiceimpl implements CommentService {
      
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentsEndpoint;

  @Autowired 
  RestTemplate restTemplate;

  @Override
  public List<Comment> getComments() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) //
        .host(this.domain)
        .path(commentsEndpoint) //
        .toUriString(); 
    
    Comment[] comments = restTemplate.getForObject(url,Comment[].class);
  
    return Arrays.asList(comments);
  }
}
