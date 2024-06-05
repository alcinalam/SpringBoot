package com.bc2403sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bc2403sb.bc_forum.infra.Scheme;
import com.bc2403sb.bc_forum.model.User;
import com.bc2403sb.bc_forum.service.UserService;

@Service
public class UserServiceimpl implements UserService {

  @Value(value = "${api.json-place-holder.domain}") 
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}" )
  private String usersEndpoint;
  
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<User> getUsers() {

     String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) // 
        .host(this.domain)
        .path(usersEndpoint) //
        .toUriString();

  User[] users = restTemplate.getForObject(url, User[].class);
  return Arrays.asList(users);      
  }
  
  
}
