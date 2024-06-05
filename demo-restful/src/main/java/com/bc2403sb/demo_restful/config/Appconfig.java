package com.bc2403sb.demo_restful.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bc2403sb.demo_restful.model.dto.Album;
import com.bc2403sb.demo_restful.model.dto.User;

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

  // List.class
  @Bean (name = "albums")
  List<Album> albums() {
    return new ArrayList<>();
  } 

}
