package com.bc2403sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bc2403sb.bc_forum.infra.Scheme;
import com.bc2403sb.bc_forum.model.Post;
import com.bc2403sb.bc_forum.service.PostService;

@Service
public class PostServiceimpl implements PostService {

    
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postsEndpoint;

  @Autowired 
  RestTemplate restTemplate;

  @Override
  public List<Post> getPosts() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) //
        .host(this.domain)
        .path(postsEndpoint) //
        .toUriString(); 
    
    Post[] posts = restTemplate.getForObject(url,Post[].class);
  
    return Arrays.asList(posts);
  }

  
  
}
