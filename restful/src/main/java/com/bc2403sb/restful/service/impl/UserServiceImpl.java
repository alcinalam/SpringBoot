package com.bc2403sb.restful.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bc2403sb.restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.restful.entity.UserEntity;
import com.bc2403sb.restful.exceptions.NotFoundException;
import com.bc2403sb.restful.infra.Scheme;
import com.bc2403sb.restful.model.dto.User;
import com.bc2403sb.restful.repository.UserRepository;
import com.bc2403sb.restful.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  // During the server start, bean creation process will consider @Value.
  // Read the yml and inject value into the bean attribute.
  @Value(value = "${api.json-place-holder.domain}") // required = true
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  // Spring will generate the class to implement the interface (UserRepository)
  // put it into context
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    // RestTemplate
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) // https or http
        .host(this.domain) //
        .path(this.usersEndpoint) //
        .toUriString(); // handle "://"

    // System.out.println("url=" + url);

    User[] users = restTemplate.getForObject(url, User[].class);
    // new RestTemplate().getForObject
    // 1. call API, and get json result
    // 2. Convert json result to java object (User[].class)
    return Arrays.asList(users);
  }

  @Override
  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  @Override
  public UserEntity deleteById(Long id) { // id not exists?
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      userRepository.deleteById(id);
      return userEntity.get();
    }
    throw new IllegalArgumentException();
  }

  @Override
  public UserEntity findById(Long id) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    throw new IllegalArgumentException();
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      userRepository.save(entity);
      return entity;
    }
    throw new IllegalArgumentException();
  }

  @Override
  public UserEntity updateEmailById(Long id, UserReqDTO dto) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      UserEntity entity = userEntity.get();
      entity.setEmail(dto.getEmail());
      userRepository.save(entity); // similar to Map put
      return entity;
    }
    throw new IllegalArgumentException();
  }

}

