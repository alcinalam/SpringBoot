package com.bc2403sb.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.bc_forum.controller.UserOperation;
import com.bc2403sb.bc_forum.dto.respDto.UserDTO;
import com.bc2403sb.bc_forum.mapper.UserMapper;
import com.bc2403sb.bc_forum.service.UserService;

@RestController
public class UserController implements UserOperation{
  
  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Override
  public List<UserDTO> getUsers() {
    return userService.getUsers().stream()//
      .map(e-> mapper.map(e)) //
      .collect(Collectors.toList());
  }

  

  
}
